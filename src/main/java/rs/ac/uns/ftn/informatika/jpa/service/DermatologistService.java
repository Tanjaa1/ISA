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
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
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
	@Autowired
	private IPharmacyRepository pharmacyRepository;

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
		dermatolgist1.setUsername(dermatologist.getUsername());
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

	public List<DermatologistDTO> getDermatologist(Long id) {
		List<DermatologistDTO> pharmacistDTOs = new ArrayList<>();
		List<Dermatologist> pharmacists = dermatologistRepository.getDermatologists(id);
		for (Dermatologist pharmacist : pharmacists) {
			pharmacistDTOs.add(new DermatologistDTO(pharmacist));
		}
		return pharmacistDTOs;
	}

	public DermatologistDTO addMark(Dermatologist pharmacist, Integer medicinesMark, Long id) {
		Dermatologist pharmacist2 = dermatologistRepository.getOne(pharmacist.getId());
		Patient patient = patientRepository.getOne(id);
		boolean i = false;
		for (Markk mark : pharmacist2.getMarks()) {
			if(mark.getPatient().getId() == patient.getId()){
				i = true;
				mark.setMarks(medicinesMark);
				//medicine2.setMarks(marks);
				break;
			}
		}
		if(!i){
			Markk mark = new Markk();
			mark.setMarks(medicinesMark);
			mark.setPatient(patient);
			Markk mm = markRepository.save(mark);
			pharmacist2.getMarks().add(mm);
			//pharmacist2.setMarks(m);
		}
		dermatologistRepository.save(pharmacist2);
		return new DermatologistDTO(pharmacist2);
	}

	public List<DermatologistDTO> getByPharmacyId(Long id) {
		List<DermatologistDTO> DermatologistDTO = new ArrayList<>();
		List<Dermatologist> dermatologists = dermatologistRepository.findAll();
		for (Dermatologist dermatologist : dermatologists) {
			for(Pharmacy p : dermatologist.getPharmacies()){
				if(p.getId().compareTo(id)==0){
					DermatologistDTO.add(new DermatologistDTO(dermatologist));
				}
			}
		}
		return DermatologistDTO;
	}

	public List<DermatologistDTO> getUnemployedDermatolgoists(Long id) {
		boolean flag = true;
		List<DermatologistDTO> DermatologistDTO = new ArrayList<>();
		List<Dermatologist> dermatologists = dermatologistRepository.findAll();
		for (Dermatologist dermatologist : dermatologists) {
			for(Pharmacy p : dermatologist.getPharmacies()){
				if(p.getId().compareTo(id)==0){
					flag = false;
				}
			}
			if(flag)
				DermatologistDTO.add(new DermatologistDTO(dermatologist));
			flag = true;
		}
		return DermatologistDTO;
	}

	public Boolean addExistingDermatologistToPharmacy(Long dId, Long pId){
		try{
			Pharmacy pharmacy = pharmacyRepository.getOne(pId);
			Dermatologist dermatologist = dermatologistRepository.getOne(dId);
			Set<Pharmacy> dPharmacies = dermatologist.getPharmacies();
			dPharmacies.add(pharmacy);
			dermatologist.setPharmacies(dPharmacies);
			dermatologistRepository.save(dermatologist);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public Dermatologist addNewDermatologistToPharmacy(Dermatologist dermatologist){

		return dermatologistRepository.save(dermatologist);

	}

	public String checkUserAndEmail(String username , String email) throws Exception {
		List<Dermatologist> dermatologists=dermatologistRepository.findAll();
		String retVal = "OK";
		for (Dermatologist d : dermatologists) {
			if(d.getUsername().equals(username)){
				retVal = "Username";
				return  retVal;
			}
			if(d.getEmail().equals(email)){
			  retVal = "Email";
			  return  retVal;
		   }			
		}
		return retVal;
		}

}
