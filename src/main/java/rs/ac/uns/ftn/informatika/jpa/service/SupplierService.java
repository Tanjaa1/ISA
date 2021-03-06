package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.ElseAction;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ISupplierService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;
	@Autowired
    private UserService userService;
    
    
    @Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	@Transactional(readOnly=false)
    public ResponseEntity<SupplierDTO> save(Supplier supplier) throws Exception {
		supplier.setLastPasswordResetDate(new Date());
        supplierRepository.save(supplier);
        List<Supplier> suppliers=supplierRepository.findAll();
		Long supplierId=0L;
		for (Supplier supplier2 : suppliers) {
			if(supplier2.getUsername().equals(supplier.getUsername()))
			supplierId=supplier2.getId();
		}
	
		supplier.setId(supplierId);
		emailSender(supplier);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

	public List<String> getAllSupplierUsernames() {
		List<Supplier> suppliers = supplierRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Supplier s : suppliers) {
            resultList.add(s.getUsername());
        }
        return resultList;
	}
	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
	public Boolean isUsernameValid(String username) {
		List<String> usernames=getAllSupplierUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}

    public Supplier findOne(Long id) {
        Supplier supplier = supplierRepository.findById(id).get();
           return supplier;
   }

    public SupplierDTO update(SupplierDTO supplier) throws Exception {
        Supplier supplier1 = findOne(supplier.getId());
        if (supplier1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		supplier1.setLastPasswordResetDate(new Date());
		supplier1.setId(supplier.getId());
		supplier1.setName(supplier.getName());
		supplier1.setSurname(supplier.getSurname());
		supplier1.setEmail(supplier.getEmail());
		supplier1.setPassword(supplier.getPassword());
		supplier1.setAddress(supplier.getAddress());
		supplier1.setCity(supplier.getCity());
		supplier1.setCountry(supplier.getCountry());
		supplier1.setPhoneNumber(supplier.getPhoneNumber());
		supplier1.setEmailComfirmed(supplier.getEmailComfirmed());
		supplier1.setFirstTimeLogin(supplier.getFirstTimeLogin());
		supplier1.setDescription(supplier.getDescription());
        supplier1.setUsername(supplier.getUsername());

        Supplier supplier2 = supplierRepository.save(supplier1);
        return new SupplierDTO(supplier2);
    }
    private void emailSender(Supplier supplier)
	{

		try {
			String subject="Supplier "+ supplier.getName() + supplier.getSurname();
			Long encriptId=IdEncryption(supplier.getId());
			String text="Dear "+ supplier.getName() + supplier.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8090/#/emailConfirmationSupplier?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(supplier.getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private Long IdEncryption(Long supplierId)
	{
		return (supplierId + 6789 + 23 * 33);          
	}

	private Long IdDecryption(Long supplierId)
	{
		return (supplierId - 23 * 33 - 6789);
	}

	public Boolean confirmationEmail(Long supplierId) throws Exception {
		Long decriptId=IdDecryption(supplierId);
		Supplier supplierToUpdate=supplierRepository.findById(decriptId).get();
		SupplierDTO supplierDTO=new SupplierDTO(supplierToUpdate);
		if(supplierDTO.getEmailComfirmed()) return false;
		supplierDTO.setEmailComfirmed(true);
		update(supplierDTO);
		return true;
	}

	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

    public Set<MedicineQuantityDTO> getAllSuppliersStokcs(Long supplierId) {
       Supplier supplier=supplierRepository.findById(supplierId).get();
	   Set<MedicineQuantity> result=supplier.getMedicines();
	   Set<MedicineQuantityDTO> result1=new HashSet<>();
	   for (MedicineQuantity medicineQuantityDTO : result) {
		result1.add(new MedicineQuantityDTO(medicineQuantityDTO));
	   }
	   return result1;
    }

    public Supplier getSupplierByCredentials(String username) {
		List<Supplier>list=supplierRepository.findAll();
		Supplier patieResult=new Supplier();
		for (Supplier patient : list) {
			if(patient.getUsername().equals(username)){
				patieResult=patient;
			}
		}
		return patieResult;
		}

    public Boolean firtTimeLogin(String username) {
		Supplier supplier=getSupplierByCredentials(username);
		return supplier.getFirstTimeLogin();
	}

}
