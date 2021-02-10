package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacistService;

@Service
public class PharmacistService implements IPharmacistService {

	@Autowired
	private IPharmacistRepository pharmacistRepository;
	@Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

	public Pharmacist findOne(Long id) {
		 return pharmacistRepository.getOne(id);
	}

	@Override
    public Pharmacist update(Pharmacist pharmacist) throws Exception {
        Pharmacist pharmacist1 = findOne(pharmacist.getId());
        if (pharmacist1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		pharmacist1.setId(pharmacist.getId());
		pharmacist1.setName(pharmacist.getName());
		pharmacist1.setSurname(pharmacist.getSurname());
		pharmacist1.setEmail(pharmacist.getEmail());
		pharmacist1.setPassword(pharmacist.getPassword());
		pharmacist1.setAddress(pharmacist.getAddress());
		pharmacist1.setCity(pharmacist.getCity());
		pharmacist1.setCountry(pharmacist.getCountry());
		pharmacist1.setPhoneNumber(pharmacist.getPhoneNumber());
		pharmacist1.setEmailComfirmed(pharmacist.getEmailComfirmed());
		pharmacist1.setFirstTimeLogin(pharmacist.getFirstTimeLogin());
		pharmacist1.setDescription(pharmacist.getDescription());
        return pharmacistRepository.save(pharmacist1);
	}
	
	@Override
	public List<PharmacistDTO> findAll() {
        ArrayList<Pharmacist> pharmacists = pharmacistRepository.findAll();
        ArrayList<PharmacistDTO> returnValue = new ArrayList<PharmacistDTO>();
        for (Pharmacist dermatologist : pharmacists) {
            returnValue.add(new PharmacistDTO(dermatologist));
        }
        return returnValue;
	}

	private void emailSender(Pharmacist pharmacist)
	{

		try {
			String subject="Pharmacist "+ pharmacist.getName() + pharmacist.getSurname();
			Long encriptId=IdEncryption(pharmacist.getId());
			String text="Dear "+ pharmacist.getName() + pharmacist.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmationPharmacist?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(pharmacist.getEmail(),subject,text);
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

	public Boolean confirmationEmail(Long pharmacistId) throws Exception {
		Long decriptId=IdDecryption(pharmacistId);
		Pharmacist pharmacistToUpdate=findOne(decriptId);
		if(pharmacistToUpdate.getEmailComfirmed()) return false;
		pharmacistToUpdate.setEmailComfirmed(true);
		update(pharmacistToUpdate);
		return true;
	}

	public ResponseEntity<Pharmacist> save(Pharmacist pharmacist) {
		pharmacistRepository.save(pharmacist);
		List<Pharmacist> patients=pharmacistRepository.findAll();
		Long pharmacistId=0L;
		for (Pharmacist patient2 : patients) {
			if(patient2.getUsername().equals(pharmacist.getUsername()))
			pharmacistId=patient2.getId();
		}
		pharmacist.setId(pharmacistId);
		emailSender(pharmacist);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}

	public Boolean isUsernameValid(String username) {
        List<String> usernames=getAllDermatologistUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}

	private List<String> getAllDermatologistUsernames() {
		List<Pharmacist> pharmacists = pharmacistRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Pharmacist s : pharmacists) {
            resultList.add(s.getUsername());
        }
        return resultList;	}

		public List<PharmacyDTO> gPharmaciesByPharmaciest(LocalDateTime startTime){
			List<PharmacyDTO> pharmacyDTOs = new ArrayList<PharmacyDTO>();
			List<Pharmacist> allPharmacists = pharmacistRepository.findAll();
			List<Pharmacist> pharmacistsExamination = pharmacistRepository.gPharmacistBySartTime(startTime);
			for (Pharmacist pharmacist : allPharmacists) {
				if(!pharmacistsExamination.contains(pharmacist) && pharmacist.checkWorkingTime(startTime) && pharmacist.checkVacationTime(startTime)){
					pharmacyDTOs.add(new PharmacyDTO(pharmacist.getPharmacy()));
				}
			}
			return pharmacyDTOs;
		}

		public List<PharmacistDTO> getPharmacistByPharmacyId(Long id) {
			List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
			List<Pharmacist> pharmacists = pharmacistRepository.gPharmacistsByPharmacyId(id);
			for (Pharmacist pharmacist : pharmacists) {
				pharmacistDTOs.add(new PharmacistDTO(pharmacist));
			}
			return pharmacistDTOs;
		}
}
