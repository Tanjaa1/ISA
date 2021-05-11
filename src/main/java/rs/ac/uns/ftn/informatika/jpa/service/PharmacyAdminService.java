package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyAdminService;

@Service
public class PharmacyAdminService implements IPharmacyAdminService {
    @Autowired
    private IPharmacyAdminRepository pharmacyAdminRepository;

   
	@Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	
    public ResponseEntity<PharmacyAdmin> save(PharmacyAdmin systemAdmin) throws Exception {
        pharmacyAdminRepository.save(systemAdmin);
		List<PharmacyAdmin> patients=pharmacyAdminRepository.findAll();
		Long patientId=0L;
		for (PharmacyAdmin patient2 : patients) {
			if(patient2.getUsername().equals(systemAdmin.getUsername()))
			    patientId=patient2.getId();
		}
		systemAdmin.setId(patientId);
		emailSender(systemAdmin);       
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<PharmacyAdmin> getAll() {
        List<PharmacyAdmin> systemAdmins = pharmacyAdminRepository.findAll();
        return systemAdmins;
    }

    public PharmacyAdmin findOne(Long id) {
        PharmacyAdmin systemAdmin = pharmacyAdminRepository.getOne(id);
        return systemAdmin;
    }

    public List<String> getAllSystemAdminUsernames() {
        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminRepository.findAll();
        List<String> resultList = new ArrayList<String>();
        for (PharmacyAdmin s : pharmacyAdmins) {
            resultList.add(s.getUsername());
        }
        return resultList;
    }

    public Boolean isUsernameValid(String username) {
        List<String> usernames = getAllSystemAdminUsernames();
        for (String s : usernames) {
            if (s.equals(username))
                return false;
        }
        return true;
    }
    
    public Boolean sendingMail(String pharmacyName,Medicine medicine)
    {
        try{
            PharmacyAdmin pharmacyAdmin = pharmacyAdminRepository.findPharmacyAdminByPharmacyName(pharmacyName);
            String subject="medicine for procurement";
            String text="Dear "+ pharmacyAdmin.getName()+" "+pharmacyAdmin.getSurname()+ ",\n\nA "
                                +medicine.getName()+" should be ordered!";
            emailService.sendNotificaitionAsync(pharmacyAdmin.getEmail(), subject, text);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public PharmacyAdmin update(PharmacyAdmin pharmacyAdmin) throws Exception {
        PharmacyAdmin pharmacyAdmin1 = findOne(pharmacyAdmin.getId());
        if (pharmacyAdmin1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		pharmacyAdmin1.setId(pharmacyAdmin.getId());
		pharmacyAdmin1.setName(pharmacyAdmin.getName());
		pharmacyAdmin1.setSurname(pharmacyAdmin.getSurname());
		pharmacyAdmin1.setEmail(pharmacyAdmin.getEmail());
		pharmacyAdmin1.setPassword(pharmacyAdmin.getPassword());
		pharmacyAdmin1.setAddress(pharmacyAdmin.getAddress());
		pharmacyAdmin1.setCity(pharmacyAdmin.getCity());
		pharmacyAdmin1.setCountry(pharmacyAdmin.getCountry());
		pharmacyAdmin1.setPhoneNumber(pharmacyAdmin.getPhoneNumber());
		pharmacyAdmin1.setEmailComfirmed(pharmacyAdmin.getEmailComfirmed());
		pharmacyAdmin1.setFirstTimeLogin(pharmacyAdmin.getFirstTimeLogin());
		pharmacyAdmin1.setDescription(pharmacyAdmin.getDescription());
        pharmacyAdmin1.setPharmacy(pharmacyAdmin.getPharmacy());
        PharmacyAdmin pharmacyAdmin2 = pharmacyAdminRepository.save(pharmacyAdmin1);
        return pharmacyAdmin2;
    }


    private void emailSender(PharmacyAdmin pharmacyAdmin)
	{

		try {
			String subject="Patient "+ pharmacyAdmin.getName() + pharmacyAdmin.getSurname();
			Long encriptId=IdEncryption(pharmacyAdmin.getId());
			String text="Dear "+ pharmacyAdmin.getName() + pharmacyAdmin.getSurname() +",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmationPharmacyAdmin?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(pharmacyAdmin.getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private Long IdEncryption(Long patientId)
	{
		return (patientId + 6789 + 23 * 33);          
	}

	private Long IdDecryption(Long patientId)
	{
		return (patientId - 23 * 33 - 6789);
	}

	public Boolean confirmationEmail(Long Id) throws Exception {
		Long decriptId=IdDecryption(Id);
		PharmacyAdmin pharmacyAdmnToUpdate=findOne(decriptId);
		if(pharmacyAdmnToUpdate.getEmailComfirmed()) return false;
		pharmacyAdmnToUpdate.setEmailComfirmed(true);
		update(pharmacyAdmnToUpdate);
		return true;
	}
}