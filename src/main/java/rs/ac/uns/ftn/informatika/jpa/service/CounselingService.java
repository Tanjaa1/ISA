package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ICounselingService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Service
public class CounselingService implements ICounselingService {

    @Autowired
	private ICounselingRpository counselingRepository;
    @Autowired
    private IExaminationRpository examinationRepository;
    @Autowired
    private LoyaltyProgrammeService loyaltyProgrammeService ;
    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IPharmacistRepository pharmacistRepository;

    @Autowired
    private IPharmacyRepository pharmacyRepository;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private PatientService patientService;
    
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

	public List<Counseling> findPastCounselingsByPatientId(Long id) {
        List<Counseling> patientCounselings = new ArrayList<>();
        List<Counseling> counselings = counselingRepository.findAll();
        for (Counseling counseling : counselings) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now());
           if(id == counseling.getPatient().getId() && counseling.getIsDone() && i < 0){
                patientCounselings.add(counseling);
            }
       }
       return patientCounselings;
	}

    public List<CouncelingDTO> findFutureCounselingsByPatientId(Long id) {
        List<CouncelingDTO> patientCounselings = new ArrayList<>();
        List<Counseling> counselings = counselingRepository.findAll();
        for (Counseling counseling : counselings) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now());
           if(id == counseling.getPatient().getId() && i > 0){
               Double price=medicineService.Discount(counseling.getPrice(), id);
              CouncelingDTO cdto=new CouncelingDTO(counseling);
            cdto.setPriceWithDiscount(price);
                patientCounselings.add(cdto);
            }
       }

       return patientCounselings;
	}

	public Counseling finish(Counseling counseling)throws Exception 
    {
            Counseling e=counselingRepository.getOne(counseling.getId());
            e.setReport(counseling.getReport());
            e.setIsDone(true);
            return counselingRepository.save(e);
	}

	public List<CouncelingDTO> getAllCounselings() {
        List<Counseling> counselings=counselingRepository.findAll();
		List<CouncelingDTO> councelingDTOs = new ArrayList<CouncelingDTO>();
        for (Counseling counseling : counselings) {
            councelingDTOs.add(new CouncelingDTO(counseling));
        }
           return councelingDTOs;
	}

	public Counseling updateCounseling(Counseling counseling) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now().plusDays(1));
		Counseling e=counselingRepository.getOne(counseling.getId());
        if(i > 0){
            e.setIsCanceled(true);
        }
            return counselingRepository.save(e);
    }
	public Set<PharmacistDTO> getPharmacisstByPatientId(Long patientId) {
		Set<PharmacistDTO> pharmacistDTOs= new HashSet();
		List<CouncelingDTO> councelingDTOs=getAllCounselings();

		for (CouncelingDTO councelingDTO : councelingDTOs) {
			if(patientId==councelingDTO.getPatient().getId()){
				pharmacistDTOs.add(councelingDTO.getPharmacist());
			}
		}	
        if(pharmacistDTOs.isEmpty()) return null;
        else return pharmacistDTOs;
	}

	public Set<PharmacyDTO> getPharmaciesByPatientId(Long patientId) {
        Set<PharmacyDTO> pharmaciesDTOs= new HashSet();
		List<CouncelingDTO> councelingDTOs=getAllCounselings();

		for (CouncelingDTO councelingDTO : councelingDTOs) {
			if(patientId==councelingDTO.getPatient().getId()){
				pharmaciesDTOs.add(councelingDTO.getPharmacy());
			}
		}	
        return pharmaciesDTOs;
	}

    
	public CouncelingDTO newCounseling(Counseling counseling) throws Exception {
        if(!counselingRepository.isExaminationExistByPharmacist(counseling.getStartTime(),counseling.getEndTime(),counseling.getPharmacist().getId()).isEmpty())
            return null;           
        if(!examinationRepository.isExaminationExistByPatient(counseling.getStartTime(),counseling.getEndTime(),counseling.getPatient().getId()).isEmpty())
            return null;
        if(!counselingRepository.isCounselingExistByPatient(counseling.getStartTime(),counseling.getEndTime(),counseling.getPatient().getId()).isEmpty())
            return null;
        if(!isPharmacistWork(counseling))
            return null;
		Counseling c=new Counseling();
        c.setPharmacist(pharmacistRepository.getOne(counseling.getPharmacist().getId()));
        c.setPatient(patientRepository.getOne(counseling.getPatient().getId()));
        c.setPharmacy(pharmacyRepository.getOne(counseling.getPharmacy().getId()));
        c.setStartTime(counseling.getStartTime());
        c.setEndTime(counseling.getEndTime());
        CouncelingDTO councelingDTO= new CouncelingDTO(counselingRepository.save(c));
        emailSender(c);
        return councelingDTO;
	}

    private Boolean isPharmacistWork(Counseling counseling) {
        for(WorkingTime w: counseling.getPharmacist().getWorkingSchedule())
            if(counseling.getStartTime().compareTo(w.getTimeStart()) > 0 && w.getTimeEnd().compareTo(counseling.getStartTime())>0
                && w.getTimeEnd().compareTo(counseling.getEndTime())>0 && counseling.getEndTime().compareTo(w.getTimeStart())>0)
                return true;
        return false;
    }
    private void emailSender(Counseling counseling)
	{
		try {
			String subject="Counseling "+ counseling.getStartTime()+" " +counseling.getEndTime();
			String text="Dear "+ counseling.getPatient().getFullName()+",\nThank you for your trust!\n\n"+counseling.getPharmacist().getFullName();
			emailService.sendNotificaitionAsync(counseling.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

    private void emailSender2(Counseling counseling)
	{
        LocalDate startDate = counseling.getStartTime().toLocalDate();
        LocalTime startTime = counseling.getStartTime().toLocalTime();
		try {
			String subject="Pharmacy "+ counseling.getPharmacy().getName()+"\n\n";
			String text="Dear "+ counseling.getPatient().getFullName()+ ",\n\n"+ "Your counseling has been scheeduled.\n"+
             "Start time:" + startDate + "  " + startTime +",\n\nThank you for your trust!\n\n Pharmacy "+counseling.getPharmacy().getName();
			emailService.sendNotificaitionAsync(counseling.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	public CouncelingDTO createNewCounseling(Counseling counseling) throws Exception {
        Counseling c = new Counseling();
        c.setPharmacist(pharmacistRepository.getOne(counseling.getPharmacist().getId()));
        c.setPatient(patientRepository.getOne(counseling.getPatient().getId()));
       // Long id = (long) 88;
        ///c.setPatient(patientRepository.findById(id).get());
        c.setPharmacy(pharmacyRepository.getOne(counseling.getPharmacy().getId()));
        c.setStartTime(counseling.getStartTime());
        c.setEndTime(counseling.getStartTime().plusMinutes(20));
        c.setPrice(counseling.getPrice());
        c.setIsDone(counseling.getIsDone());
        c.setIsCanceled(counseling.getIsCanceled());
        Double price=medicineService.Discount(counseling.getPrice(),counseling.getPatient().getId());
        c.setPrice(price);
        LoyaltyProgramme lpDTO=loyaltyProgrammeService.findById(Long.valueOf(1));
        Patient patient =counseling.getPatient();
        patient.setPoints(patient.getPoints()+lpDTO.getPointsForCounceling());
        patientService.update(patient);
        CouncelingDTO councelingDTO= new CouncelingDTO(counselingRepository.save(c));
        emailSender2(c);
        return councelingDTO;
	}

	public List<CouncelingDTO> getCounselingByPharmacist(Long id) {
		List<CouncelingDTO> councelingDTO=new ArrayList<CouncelingDTO>();

		for (Counseling counseling : counselingRepository.getCounselingByPharmacist(id))
        councelingDTO.add(new CouncelingDTO(counseling));
        return councelingDTO;
	}
}
