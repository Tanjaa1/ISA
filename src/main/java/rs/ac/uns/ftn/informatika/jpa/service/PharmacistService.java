package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IWorkTimeRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Service
public class PharmacistService implements IPharmacistService {

	@Autowired
	private IPharmacistRepository pharmacistRepository;
	@Autowired
	private IPatientRepository patientRepository;
	@Autowired
	private IMarkRepository markRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	private IPharmacyRepository pharmacyRepository;
	@Autowired
	private IWorkTimeRepository wtrepository;
	@Autowired
	private ICounselingRpository counselingRpository;

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
		pharmacist1.setUsername(pharmacist.getUsername());
        return pharmacistRepository.save(pharmacist1);
	}
	
	@Override
	public List<PharmacistDTO> findAll() {
        List<Pharmacist> pharmacists = pharmacistRepository.findAll();
        List<PharmacistDTO> returnValue = new ArrayList<PharmacistDTO>();
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
			String text="Dear "+ pharmacist.getName() + pharmacist.getSurname()+",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8090/#/emailConfirmationPharmacist?id=" + encriptId + "\">link</a>!";
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
		
	public List<PharmacistDTO> getPharmacists(Long id) {
			List<PharmacistDTO> pharmacistDTOs = new ArrayList<>();
			List<Pharmacist> pharmacists = pharmacistRepository.getPharmacists(id);
			for (Pharmacist pharmacist : pharmacists) {
				pharmacistDTOs.add(new PharmacistDTO(pharmacist));
			}
			return pharmacistDTOs;
		}

	public PharmacistDTO addMark(Pharmacist pharmacist, Integer medicinesMark, Long id) {
			Pharmacist pharmacist2 = pharmacistRepository.getOne(pharmacist.getId());
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
			pharmacistRepository.save(pharmacist2);
			return new PharmacistDTO(pharmacist2);
		}

        public Pharmacist getPharmacistByCredentials(String username) {
			List<Pharmacist>list=pharmacistRepository.findAll();
			Pharmacist patieResult=new Pharmacist();
			for (Pharmacist patient : list) {
				if(patient.getUsername().equals(username)){
					patieResult=patient;
				}
			}
			return patieResult;
			}

	public Pharmacist addNewPharmacistToPharmacy(Pharmacist dermatologist){

			return pharmacistRepository.save(dermatologist);
	
		}

		
	public Boolean addExistingPharmacistToPharmacy(Long dId, Long pId){
			try{
				Pharmacy pharmacy = pharmacyRepository.getById(pId);
				Pharmacist pharmacist = pharmacistRepository.getOne(dId);
				pharmacist.setPharmacy(pharmacy);
				pharmacistRepository.save(pharmacist);
				return true;
			}
			catch(Exception e){
				return false;
			}
		}
	
	public String checkUserAndEmail(String username , String email) throws Exception {
			List<Pharmacist> pharmacists=pharmacistRepository.findAll();
			String retVal = "OK";
			for (Pharmacist p : pharmacists) {
				if(p.getUsername().equals(username)){
					retVal = "Username";
					return  retVal;
				}
				if(p.getEmail().equals(email)){
				  retVal = "Email";
				  return  retVal;
			   }			
			}
			return retVal;
		}

	public List<PharmacistDTO> getUnemployedPharmacists(Long id) {
			List<PharmacistDTO> pharmacistDTOs = new ArrayList<>();
			List<Pharmacist> pharmacists = pharmacistRepository.findAll();
			for (Pharmacist pharmacist : pharmacists) {
					if(pharmacist.getPharmacy().getId().compareTo(id)!=0)
						pharmacistDTOs.add(new PharmacistDTO(pharmacist));
				}
			return pharmacistDTOs;
		}


	public Boolean checkIfWorktimeValid(LocalDateTime start,LocalDateTime end,Long Id){
		WorkingTime workingTime = new WorkingTime();
		workingTime.setTimeEnd(end);
		workingTime.setTimeStart(start);

		Pharmacist pharmacist = pharmacistRepository.getOne(Id);
		if(pharmacist.getWorkingSchedule().isEmpty())
			return true;
		for(WorkingTime w: pharmacist.getWorkingSchedule())
				if(workingTime.getTimeStart().compareTo(w.getTimeStart()) < 0 && workingTime.getTimeEnd().compareTo(w.getTimeStart()) > 0 && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0
				|| workingTime.getTimeStart().compareTo(w.getTimeStart()) > 0 && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0 && workingTime.getTimeStart().compareTo(w.getTimeEnd()) <0
				|| 	workingTime.getTimeStart().compareTo(w.getTimeStart()) > 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0
				|| workingTime.getTimeStart().compareTo(w.getTimeStart()) < 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0
				|| workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) == 0
				|| workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) < 0
				|| workingTime.getTimeStart().compareTo(w.getTimeStart()) == 0  && workingTime.getTimeEnd().compareTo(w.getTimeEnd()) > 0)
					return false;
			return true;
	}

	public Boolean addWorktimeToPharmacist(Long pId,WorkingTime wt){
		Pharmacist pharmacist = pharmacistRepository.getOne(pId);
		if(checkIfWorktimeValid(wt.getTimeStart(), wt.getTimeEnd(),pId)){
				wtrepository.save(wt);
				Set<WorkingTime> wtS = pharmacist.getWorkingSchedule();
				wtS.add(wt);
				pharmacist.setWorkingSchedule(wtS);	
				pharmacistRepository.save(pharmacist);
				return true;
		}
		return false;
	}

	public Boolean removeFromPharmacy(Long pID){
		if(counselingRpository.getUpcomingCounselingByPharmacist(pID).isEmpty()){
			Pharmacist p = pharmacistRepository.getOne(pID);
			p.setPharmacy(null);
			pharmacistRepository.save(p);
			return true;
		}
		else return false;
	}
}
