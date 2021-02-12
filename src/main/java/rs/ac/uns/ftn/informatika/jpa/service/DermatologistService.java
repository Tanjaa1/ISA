package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Mark;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {


	@Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	
	@Autowired
	private IDermatologistRepository dermatologistRepository;

	@Autowired
	private IPatientRepository patientRepository;

	@Autowired
	private IMarkRepository markRepository;

	public Dermatologist findOne(Long id) 
	{
		 return dermatologistRepository.getOne(id);
	}

	@Override
    public Dermatologist update(Dermatologist dermatologist) throws Exception 
	{
        Dermatologist dermatolgist1 = findOne(dermatologist.getId());
        if (dermatolgist1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
		dermatolgist1.setId(dermatologist.getId());
		dermatolgist1.setName(dermatologist.getName());
		dermatolgist1.setSurname(dermatologist.getSurname());
		dermatolgist1.setEmail(dermatologist.getEmail());
		dermatolgist1.setPassword(dermatologist.getPassword());
		dermatolgist1.setAddress(dermatologist.getAddress());
		dermatolgist1.setCity(dermatologist.getCity());
		dermatolgist1.setCountry(dermatologist.getCountry());
		dermatolgist1.setPhoneNumber(dermatologist.getPhoneNumber());
		dermatolgist1.setEmailComfirmed(dermatologist.getEmailComfirmed());
		dermatolgist1.setFirstTimeLogin(dermatologist.getFirstTimeLogin());
		dermatolgist1.setDescription(dermatologist.getDescription());
        return dermatologistRepository.save(dermatolgist1);
    }
  
   @Override
    public List<DermatologistDTO> findAll() {
        DermatologistDTO dermatologistDTO = new DermatologistDTO();
        List<Dermatologist> dermatologists = dermatologistRepository.findAll();
        List<DermatologistDTO> returnValue = new ArrayList<DermatologistDTO>();
        for (Dermatologist dermatologist : dermatologists)
            returnValue.add(dermatologistDTO.toDTO(dermatologist));
        return returnValue;
    }

	@Override
    public ResponseEntity<Dermatologist> save(Dermatologist dermatologist) throws Exception {
        dermatologistRepository.save(dermatologist);
		List<Dermatologist> dermatologists=dermatologistRepository.findAll();
		Long dermaId=0L;
		for (Dermatologist dermatologist2 : dermatologists) {
			if(dermatologist2.getUsername().equals(dermatologist.getUsername()))
			dermaId=dermatologist2.getId();
		}
		dermatologist.setId(dermaId);
		emailSender(dermatologist);
		return new ResponseEntity<>( HttpStatus.CREATED);  
	  }

	public List<String> getAllDermatologistUsernames() {
		List<Dermatologist> dermatologists = dermatologistRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Dermatologist s : dermatologists) {
            resultList.add(s.getUsername());
        }
        return resultList;
	}

	public Boolean isUsernameValid(String username) {
        List<String> usernames=getAllDermatologistUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}

	private void emailSender(Dermatologist dermatologist)
	{

		try {
			String subject="Patient "+ dermatologist.getName()+dermatologist.getSurname();
			Long encriptId=IdEncryption(dermatologist.getId());
			String text="Dear "+ dermatologist.getName()+dermatologist.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmationDermatologist?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(dermatologist.getEmail(),subject,text);
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
		Dermatologist dermaToUpdate=findOne(decriptId);
		if(dermaToUpdate.getEmailComfirmed()) return false;
		dermaToUpdate.setEmailComfirmed(true);
		update(dermaToUpdate);
		return true;
	}

	public List<DermatologistDTO> getDermatologists(Long id){
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<>();
		List<Dermatologist> dermatologists = dermatologistRepository.getDermatologists(id);
		for (Dermatologist dermatologist : dermatologists) {
			dermatologistDTOs.add(new DermatologistDTO(dermatologist));
		}
		return dermatologistDTOs;
	}

	public DermatologistDTO addMark(Dermatologist dermatologist, Integer dermatologistMark, Long id) {
		Dermatologist dermatologist2 = dermatologistRepository.getOne(dermatologist.getId());
		Patient patient = patientRepository.getOne(id);
		boolean i = false;
		for (Mark mark : dermatologist2.getMarks()) {
			if(mark.getPatient().getId() == patient.getId()){
				i = true;
				mark.setMarks(dermatologistMark);
				//medicine2.setMarks(marks);
				break;
			}
		}
		if(!i){
			Set<Mark> m = dermatologist2.getMarks();
			Mark mark = new Mark(dermatologistMark, patient);
			m.add(mark);
			markRepository.save(mark);
			dermatologist2.setMarks(m);
		}
		dermatologistRepository.save(dermatologist2);
		return new DermatologistDTO(dermatologist2);
	
	}

}
