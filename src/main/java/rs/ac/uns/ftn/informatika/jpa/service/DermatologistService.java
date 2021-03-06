package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IWorkTimeRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IDermatologistService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
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
	@Autowired
	private IWorkTimeRepository wTimeRepository;
	@Autowired
	private IExaminationRpository examinationRpository;

	public Dermatologist findOne(Long id) 
	{
		 return dermatologistRepository.getOne(id);
	}

	@Override
	@Transactional(readOnly=false)
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
	@Transactional(readOnly=false)
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
	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
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
			String text="Dear "+ dermatologist.getName()+dermatologist.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8090/#/emailConfirmationDermatologist?id=" + encriptId + "\">link</a>!";
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

    public Dermatologist getDermatologistByCredentials(String username) {
		List<Dermatologist>list=dermatologistRepository.findAll();
		Dermatologist patieResult=new Dermatologist();
		for (Dermatologist patient : list) {
			if(patient.getUsername().equals(username)){
				patieResult=patient;
			}
		}
		return patieResult;
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

	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
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


		public Boolean checkIfWorktimeValid(LocalDateTime start,LocalDateTime end,Long Id){
			WorkingTime workingTime = new WorkingTime();
			workingTime.setTimeEnd(end);
			workingTime.setTimeStart(start);
	
			Dermatologist dermatologist = dermatologistRepository.getOne(Id);
			if(dermatologist.getWorkingSchedule().isEmpty())
				return true;
			for(WorkingTime w: dermatologist.getWorkingSchedule())
					if((workingTime.getTimeStart().compareTo(w.getTimeStart()) < 0 && workingTime.getTimeEnd().compareTo(w.getTimeStart()) > 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0)
					||(workingTime.getTimeStart().compareTo(w.getTimeStart()) > 0 && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0 && workingTime.getTimeStart().compareTo(w.getTimeEnd()) <0)
					|| (workingTime.getTimeStart().compareTo(w.getTimeStart()) > 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0)
					||( workingTime.getTimeStart().compareTo(w.getTimeStart()) < 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0)
					|| (workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) == 0)
					|| (workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0)
					|| (workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0 ))
						return false;
				return true;
		}
		
		@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
		public Boolean addWorktimeToDermatologist(Long pId,WorkingTime wt){
			Dermatologist dermatologist = dermatologistRepository.getOne(pId);
			if(checkIfWorktimeValid(wt.getTimeStart(), wt.getTimeEnd(),pId)){
					wTimeRepository.save(wt);
					Set<WorkingTime> wtS = dermatologist.getWorkingSchedule();
					wtS.add(wt);
					dermatologist.setWorkingSchedule(wtS);	
					dermatologistRepository.save(dermatologist);
					return true;
			}
			return false;
		}

		@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
		public Boolean removeFromPharmacy(Long dId, Long pId){
			try{
				if(examinationRpository.checkForDelete(pId, dId).isEmpty()){
					Set<Pharmacy> pharmacies = new HashSet<Pharmacy>();
					Dermatologist dermatologist = dermatologistRepository.getOne(dId);
					for (Pharmacy ph : pharmacies) {
						if(ph.getId().compareTo(pId) != 0)
							pharmacies.add(ph);
					}
					dermatologist.setPharmacies(pharmacies);
					dermatologistRepository.save(dermatologist);
					return true;
				}
			else return false;
			}
			catch(Exception e){
				return false;
			}
		}
}
