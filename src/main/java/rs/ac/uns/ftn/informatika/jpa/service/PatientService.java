package rs.ac.uns.ftn.informatika.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IActionOrPromotionRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPenaltyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPatientService;
@Configuration
@Service
public class PatientService implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;
	
	@Autowired
	private IComplaintRepository complaintRepository;

	@Autowired
	private IReservationRepository reservationRepository;
	
	@Autowired
	private IPenaltyRepository penaltyRepository;
	@Autowired
	private IActionOrPromotionRepository actionOrPromotionRepository;
	
	
	@Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

	public Patient findOne(Long id) {
		Patient patient = patientRepository.getOne(id);
		List<Reservation> reservations = reservationRepository.getReservationsByPatientId(id);
		int ii = LocalDate.now().getDayOfMonth();
		if(ii == 1 && !patient.getPenalty().isEmpty()){
			for (Penaltys penaltys : patient.getPenalty()){
				penaltys.setIsDeleted(true);
				penaltys.setPenaltyNymber(0);
				penaltyRepository.save(penaltys);
			}
		patientRepository.save(patient);
		}
		return CheckPenaltys(reservations, patient);	
	}
	public PatientDTO findByIdPatient(Long id){
		Patient patient=patientRepository.findById(id).get();
		return new PatientDTO(patient);
	}

	private Patient CheckPenaltys(List<Reservation> reservations, Patient patient) {
		if(patient.getPenalty().isEmpty()){
			for (Reservation reservation : reservations) {
					int i = reservation.getExpirationDate().compareTo(new Date());
					if(i < 0 && !reservation.getIsCanceled() && !reservation.getIsReceived()){
						Penaltys p = new Penaltys();
						p.setPenaltyNymber(1);
						p.setIsDeleted(false);
						p.setReservation(reservation.getId());
						penaltyRepository.save(p);
						patient.getPenalty().add(p);
					}
			}
		}else{
			for (Reservation reservation : reservations) {
				boolean t = false;
				for (Penaltys penaltys : patient.getPenalty()) {
					int i = reservation.getExpirationDate().compareTo(new Date());
					if(penaltys.getIsDeleted() || i > 0 || reservation.getIsCanceled() || reservation.getIsReceived() ||
						penaltys.getReservation() == reservation.getId()){
							t = true;
					}
				}
				if(!t){
					Penaltys p = new Penaltys();
					p.setPenaltyNymber(1);
					p.setIsDeleted(false);
					p.setReservation(reservation.getId());
					penaltyRepository.save(p);
					patient.getPenalty().add(p);
				}
			}
		}
		Patient pp = patientRepository.save(patient);
		return pp;
	}

	@Override
	public Patient update(Patient patient) throws Exception {
		Patient patient1 = findOne(patient.getId());
		if (patient1 == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		patient1.setId(patient.getId());
		patient1.setName(patient.getName());
		patient1.setSurname(patient.getSurname());
		patient1.setEmail(patient.getEmail());
		patient1.setPassword(patient.getPassword());
		patient1.setAddress(patient.getAddress());
		patient1.setCity(patient.getCity());
		patient1.setCountry(patient.getCountry());
		patient1.setPhoneNumber(patient.getPhoneNumber());
		patient1.setCategory(patient.getCategory());
		patient1.setPoints(patient.getPoints());
		patient1.setPenalty(patient.getPenalty());
		patient1.setEmailComfirmed(patient.getEmailComfirmed());
		patient1.setFirstTimeLogin(patient.getFirstTimeLogin());
		patient1.setDescription(patient.getDescription());
		patient1.setDrugAllargies(patient.getDrugAllargies());
		Patient patient2 = patientRepository.save(patient1);
		return patient2;
	}
	public Patient updatePatient(Patient patient) throws Exception {
		PatientDTO patient11 =findByIdPatient(patient.getId());
		if (patient11 == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Patient patient1=new Patient(patient11);

		patient1.setId(patient.getId());
		patient1.setName(patient.getName());
		patient1.setUsername(patient.getUsername());
		patient1.setSurname(patient.getSurname());
		patient1.setEmail(patient.getEmail());
		patient1.setPassword(patient.getPassword());
		patient1.setAddress(patient.getAddress());
		patient1.setCity(patient.getCity());
		patient1.setCountry(patient.getCountry());
		patient1.setPhoneNumber(patient.getPhoneNumber());
		patient1.setCategory(patient.getCategory());
		patient1.setPoints(patient.getPoints());
		patient1.setPenalty(patient.getPenalty());
		patient1.setEmailComfirmed(patient.getEmailComfirmed());
		patient1.setFirstTimeLogin(patient.getFirstTimeLogin());
		patient1.setDescription(patient.getDescription());
		patient1.setDrugAllargies(patient.getDrugAllargies());
		patient1.setActionOrPromotion(patient.getActionOrPromotion());
		Patient patient2 = patientRepository.save(patient1);
		return patient2;
	}

	public List<PatientDTO> findPatientsByDermatologist(Long id) {
		List<PatientDTO> patientsDto = new ArrayList<PatientDTO>();
		for (Patient patient : patientRepository.findPatientsByDermatologist(id))
			patientsDto.add(new PatientDTO(patient));
		return patientsDto;
	}

	public List<PatientDTO> findPatientsByPharmacist(Long id) {
		List<PatientDTO> patientsDto = new ArrayList<PatientDTO>();
		for (Patient patient : patientRepository.findPatientsByPharmacist(id))
			patientsDto.add(new PatientDTO(patient));
		return patientsDto;
	}

	public List<PatientDTO> findPatientsByNameAndSurnameDermatologist(Long id, String name, String surname) {
		List<PatientDTO> patients = new ArrayList<PatientDTO>();
		for (PatientDTO patientDTO : findPatientsByDermatologist(id)) {
			if (patientDTO.containsNameAndSurname(name, surname))
				patients.add(patientDTO);
		}
		return patients;
	}

	public List<PatientDTO> findPatientsByNameAndSurnamePharmacist(Long id, String name, String surname) {
		List<PatientDTO> patients = new ArrayList<PatientDTO>();
		for (PatientDTO patientDTO : findPatientsByPharmacist(id)) {
			if (patientDTO.containsNameAndSurname(name, surname))
				patients.add(patientDTO);
		}
		return patients;
	}

	public ResponseEntity<Patient> save(Patient patient) throws Exception {
		patient.setCategory(LoyaltyCategories.Regular);
		patient.setLastPasswordResetDate(new Date());
		patientRepository.save(patient);
		List<Patient> patients = patientRepository.findAll();
		Long patientId = 0L;
		for (Patient patient2 : patients) {
			if (patient2.getUsername().equals(patient.getUsername()))
				patientId = patient2.getId();
		}
		patient.setId(patientId);
		emailSender(patient);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public List<String> saveDrugAll(String drugAllergies) throws Exception {
		String drugAllergiesParts[] = drugAllergies.split(",");
		List<String> listdrugAllergies = new ArrayList<String>();
		for (String i : drugAllergiesParts) {
			listdrugAllergies.add(i);
		}
		return listdrugAllergies;
	}

	public List<String> getAllPatientUsernames() {
		List<Patient> patients = patientRepository.findAll();
		List<String> resultList = new ArrayList<String>();
		for (Patient s : patients) {
			resultList.add(s.getUsername());
		}
		return resultList;
	}

	public Boolean isUsernameValid(String username) {
		List<String> usernames = getAllPatientUsernames();
		for (String s : usernames) {
			if (s.equals(username))
				return false;
		}
		return true;
	}

	private void emailSender(Patient patient) {
		try {
			String subject = "Patient " + patient.getFullName();
			Long encriptId = IdEncryption(patient.getId());
			String text = "Dear " + patient.getFullName()
					+ ",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8080/#/emailConfirmation?id="
					+ encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(patient.getEmail(), subject, text);
		} catch (Exception e) {
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private void emailSenderActionsOrPromotions(Patient patient,ActionOrPromotion actionOrPromotion) {
		try {
			String subject = "Patient " + patient.getFullName();
			String text = "Dear " + patient.getFullName()
					+ ",\nWe would like to inform you that you have subscribed to actions and promotions: \n"
					+ actionOrPromotion.getText();
			emailService.sendNotificaitionAsync(patient.getEmail(), subject, text);
		} catch (Exception e) {
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private void emailSenderActionsOrPromotionsCancel(Patient patient,ActionOrPromotion actionOrPromotion) {
		try {
			String subject = "Patient " + patient.getFullName();
			String text = "Dear " + patient.getFullName()
					+ ",\nyou have cancelled  subscripton from the following promotions and promotions: \n"
					+ actionOrPromotion.getText();
			emailService.sendNotificaitionAsync(patient.getEmail(), subject, text);
		} catch (Exception e) {
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private Long IdEncryption(Long patientId) {
		return (patientId + 6789 + 23 * 33);
	}

	private Long IdDecryption(Long patientId) {
		return (patientId - 23 * 33 - 6789);
	}

	public Boolean confirmationEmail(Long patientId) throws Exception {
		Long decriptId = IdDecryption(patientId);
		Patient patientToUpdate = findOne(decriptId);
		if (patientToUpdate.getEmailComfirmed())
			return false;
		patientToUpdate.setEmailComfirmed(true);
		update(patientToUpdate);
		return true;
	}

	public Set<PharmacyDTO> getEPharmaciesByPatientIdAndPrescriptions(Long patientId) {
		PatientDTO resultPatient = new PatientDTO((findOne(patientId)));
		Set<EPrescriptionDTO> prescriptions = resultPatient.getEPrescriptions();
		Set<PharmacyDTO> pharmacies = new HashSet<>();
		for (EPrescriptionDTO s : prescriptions) {
			pharmacies.add(s.getPharmacy());
		}
		if (pharmacies.isEmpty())
			return null;
		else
			return pharmacies;
	}

	@Override
	public Patient findById(Long id) {
		Patient patient = patientRepository.findById(id).get();
		return patient;
	}

	public List<PatientDTO> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		List<PatientDTO> returnValue = new ArrayList<PatientDTO>();
		for (Patient patient : patients)
			returnValue.add(new PatientDTO(patient));
		return returnValue;
	}

	public PatientDTO findByIdComplaints(Long id) {
		Complaint complaint = complaintRepository.getOne(id);
		Patient patient = patientRepository.findById(complaint.getPatient().getId()).get();
		return new PatientDTO(patient);
	}

	@Override
	public List<Patient> findSubscribetPatients(Long pharmacyId) {
		return patientRepository.findPatientsSubscribed(pharmacyId);
	}

    public ActionOrPromotionsDTO saveActionOrPromotion(String patientId, ActionOrPromotionsDTO actionOrPromotionsDTO) throws Exception {
        Long PatientId=Integer.toUnsignedLong(Integer.valueOf(patientId));
		Patient patientToUpdate=patientRepository.findById(PatientId).get();

		//Set<ActionOrPromotion>actionOrPromotionsSet=new HashSet<>();
		/*ActionOrPromotion a=new ActionOrPromotion(actionOrPromotionsDTO);
		a.setId(actionOrPromotionsDTO.getId());
		actionOrPromotionsSet.add(a);
		*/
		Set<ActionOrPromotion> newSet=new HashSet<>();
		newSet.addAll(patientToUpdate.getActionOrPromotion());
		newSet.add(new ActionOrPromotion(actionOrPromotionsDTO));
		patientToUpdate.setActionOrPromotion(newSet);
		updatePatient(patientToUpdate);
		emailSenderActionsOrPromotions(patientToUpdate,new ActionOrPromotion(actionOrPromotionsDTO));
		//emailSender(patientToUpdate);
		return actionOrPromotionsDTO;
	}

	public ActionOrPromotionsDTO cancelActionOrPromotion(String id, String idAction) throws Exception {
		

		Long PatientId=Integer.toUnsignedLong(Integer.valueOf(id));	
		Long actionOrPromotionId=Integer.toUnsignedLong(Integer.valueOf(idAction));

		Patient patientToUpdate=patientRepository.findById(PatientId).get();
		ActionOrPromotion toCancel=actionOrPromotionRepository.getOne(actionOrPromotionId);
		Set<ActionOrPromotion> newSetA=patientToUpdate.getActionOrPromotion();
		newSetA.remove(toCancel);
		patientToUpdate.setActionOrPromotion(newSetA);
		update(patientToUpdate);
		emailSenderActionsOrPromotionsCancel(patientToUpdate,toCancel);

		return new ActionOrPromotionsDTO(toCancel);
		}

	public Set<ActionOrPromotionsDTO> getAllActionsAndPromotionByPatientId(String patientId) {
		Long PatientId=Integer.toUnsignedLong(Integer.valueOf(patientId));

		Patient patient=patientRepository.getOne(PatientId);
		Set<ActionOrPromotion> resultList=new HashSet<>();
		resultList=patient.getActionOrPromotion();

		Set<ActionOrPromotionsDTO> rSet=new HashSet<>();
		for(ActionOrPromotion actionOrPromotion : resultList){
			rSet.add(new ActionOrPromotionsDTO(actionOrPromotion));
		}
		return rSet;
	}
    public Patient getPatientByCredentials(String username) {
		List<Patient>list=patientRepository.findAll();
		Patient patieResult=new Patient();
		for (Patient patient : list) {
			if(patient.getUsername().equals(username)){
				patieResult=patient;
			}
		}
		return patieResult;
		}

	
	
}
