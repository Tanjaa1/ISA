package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.SystemAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISystemAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ISystemAdminService;

@Service
public class SystemAdminService implements ISystemAdminService {
    @Autowired
    private ISystemAdminRepository systemAdminRepository;
    @Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

    public ResponseEntity<SystemAdmin> save(SystemAdmin systemAdmin) throws Exception {
        systemAdminRepository.save(systemAdmin);
		List<SystemAdmin> patients=systemAdminRepository.findAll();
		Long patientId=0L;
		for (SystemAdmin patient2 : patients) {
			if(patient2.getUsername().equals(systemAdmin.getUsername()))
				patientId=patient2.getId();
		}
		systemAdmin.setId(patientId);
		emailSender(systemAdmin);  
	  return new ResponseEntity<>( HttpStatus.CREATED);
    }
   

    public List<SystemAdmin> getAll() {
        List<SystemAdmin> systemAdmins = systemAdminRepository.findAll();
           return systemAdmins;
   }

   public SystemAdmin findOne(Long id) {
    SystemAdmin systemAdmin = systemAdminRepository.getOne(id);
       return systemAdmin;
    }

    public List<String> getAllSystemAdinUsernames() {
        List<SystemAdmin> systemAdmins = systemAdminRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (SystemAdmin s : systemAdmins) {
            resultList.add(s.getUsername());
        }
        return resultList;
    }

	public Boolean isUsernameValid(String username) {
		List<String> usernames=getAllSystemAdinUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}

	private void emailSender(SystemAdmin systemAdmin)
	{

		try {
			String subject="Patient "+ systemAdmin.getName() + systemAdmin.getSurname();
			Long encriptId=IdEncryption(systemAdmin.getId());
			String text="Dear "+systemAdmin.getName() + systemAdmin.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmationSystemAdmin?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(systemAdmin.getEmail(),subject,text);
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

	public Boolean confirmationEmail(Long patientId) throws Exception {
		Long decriptId=IdDecryption(patientId);
		SystemAdmin patientToUpdate=findOne(decriptId);
		if(patientToUpdate.getEmailComfirmed()) return false;
		patientToUpdate.setEmailComfirmed(true);
		update(patientToUpdate);
		return true;
	}

    @Override
    public SystemAdmin update(SystemAdmin systemAdmin) throws Exception {
        SystemAdmin patient1 = findOne(systemAdmin.getId());
        if (patient1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		patient1.setId(systemAdmin.getId());
		patient1.setName(systemAdmin.getName());
		patient1.setSurname(systemAdmin.getSurname());
		patient1.setEmail(systemAdmin.getEmail());
		patient1.setPassword(systemAdmin.getPassword());
		patient1.setAddress(systemAdmin.getAddress());
		patient1.setCity(systemAdmin.getCity());
		patient1.setCountry(systemAdmin.getCountry());
		patient1.setPhoneNumber(systemAdmin.getPhoneNumber());
		patient1.setEmailComfirmed(systemAdmin.getEmailComfirmed());
		patient1.setFirstTimeLogin(systemAdmin.getFirstTimeLogin());
		patient1.setDescription(systemAdmin.getDescription());
        SystemAdmin systemAdmin2 = systemAdminRepository.save(patient1);
        return systemAdmin2;
    }


    public SystemAdmin getSystemAdminByCredentials(String username) {
		List<SystemAdmin>list=systemAdminRepository.findAll();
		SystemAdmin patieResult=new SystemAdmin();
		for (SystemAdmin patient : list) {
			if(patient.getUsername().equals(username)){
				patieResult=patient;
			}
		}
		return patieResult;
		}
}
