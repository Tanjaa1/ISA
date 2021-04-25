package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ISupplierService;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;
    
    @Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
    
    public ResponseEntity<Supplier> save(Supplier supplier) throws Exception {
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

    @Override
    public Supplier update(Supplier supplier) throws Exception {
        Supplier supplier1 = findOne(supplier.getId());
        if (supplier1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
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
        return supplier2;
    }
    private void emailSender(Supplier supplier)
	{

		try {
			String subject="Supplier "+ supplier.getName() + supplier.getSurname();
			Long encriptId=IdEncryption(supplier.getId());
			String text="Dear "+ supplier.getName() + supplier.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmationSupplier?id=" + encriptId + "\">link</a>!";
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
		Supplier supplierToUpdate=findOne(decriptId);
		if(supplierToUpdate.getEmailComfirmed()) return false;
		supplierToUpdate.setEmailComfirmed(true);
		update(supplierToUpdate);
		return true;
	}

	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

}
