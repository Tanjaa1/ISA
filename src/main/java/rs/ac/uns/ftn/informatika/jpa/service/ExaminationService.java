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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IExaminationService;
import rs.ac.uns.ftn.informatika.jpa.util.MedicineGraphInfo;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Service
@Transactional(readOnly = true)
public class ExaminationService implements IExaminationService {

    @Autowired
    private IExaminationRpository examinationRepository;

    @Autowired
    private ICounselingRpository counselingRepository;
    
    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDermatologistRepository dermatologistRepository;

    @Autowired
    private IPharmacyRepository pharmacyRepository;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private LoyaltyProgrammeService loyaltyProgrammeService;
    
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

    public List<Examination> findPastExaminationsByPatientId(Long id) {
        List<Examination> patientExaminations = new ArrayList<>();
        List<Examination> examinations = examinationRepository.findAll();
        for (Examination examination : examinations) {
            int i = examination.getStartTime().compareTo(LocalDateTime.now());
            if (examination.getPatient() != null && id == examination.getPatient().getId() && examination.getIsDone() && i < 0) {
                patientExaminations.add(examination);
            }
        }
        return patientExaminations;
    }

    public List<ExaminationDTO> findFutureExaminationsByPatientId(Long id) {
        List<ExaminationDTO> patientExaminations = new ArrayList<>();
        List<Examination> examinations = examinationRepository.findAll();
        for (Examination examination : examinations) {
            int i = examination.getStartTime().compareTo(LocalDateTime.now());
            if (examination.getPatient() != null && id == examination.getPatient().getId() && i > 0) {
                ExaminationDTO cdto=new ExaminationDTO(examination);
                patientExaminations.add(cdto);
            }
        }
        return patientExaminations;
    }

	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public Examination finish(Examination examination) throws Exception {
        Examination e=examinationRepository.getOne(examination.getId());
        e.setReport(examination.getReport());
        e.setIsDone(true);
        return examinationRepository.save(e);
    }

    public Examination updateExamination(Examination examination) throws Exception {
        int i = examination.getStartTime().compareTo(LocalDateTime.now().plusDays(1));
        Examination e=examinationRepository.getOne(examination.getId());
        if(i > 0){
            e.setIsCanceled(true);
        }
        return examinationRepository.save(e);
    }

    @Override
	public Examination getExaminationById(Long id) {
        return examinationRepository.getOne(id);
	}

	public List<ExaminationDTO> getAllExaminations() {
        List<Examination> examinations=examinationRepository.findAll();
		List<ExaminationDTO> examinationsDtos = new ArrayList<ExaminationDTO>();
        for (Examination examination : examinations) {
            examinationsDtos.add(new ExaminationDTO(examination));
        }
           return examinationsDtos;
	}

	public List<ExaminationDTO> getFreeExaminationByDermatologist(Long id) {
		List<ExaminationDTO> examinationsDtos = new ArrayList<ExaminationDTO>();
        for (Examination examination : examinationRepository.getFreeExaminationByDermatologist(id))
            if (examination.getStartTime().compareTo(LocalDateTime.now()) > 0)
                examinationsDtos.add(new ExaminationDTO(examination));
        return examinationsDtos;
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
	public ExaminationDTO schedule(Examination examination) throws Exception{
        Examination e=examinationRepository.getOne(examination.getId());
        e.setPatient(patientRepository.getOne(examination.getPatient().getId()));
        e.setIsCanceled(false);
        emailSender2(examination);
        examinationRepository.save(e);
        ExaminationDTO eDTO=new ExaminationDTO(examination);
        Double price=medicineService.Discount(examination.getPrice(),examination.getPatient().getId());
        e.setPriceWithDiscount(price);
        examinationRepository.save(e);
        Patient patient =examination.getPatient();
        LoyaltyProgramme lpDTO=loyaltyProgrammeService.findById(Long.valueOf(1));
        patient.setPoints(patient.getPoints()+lpDTO.getPointsForCounceling());   
        patientService.update(patient);
        return eDTO;
	}

    
    private void emailSender2(Examination examination)
	{
        LocalDate startDate = examination.getStartTime().toLocalDate();
        LocalTime startTime = examination.getStartTime().toLocalTime();
		try {
			String subject="Pharmacy "+ examination.getPharmacy().getName()+"\n\n";
			String text="Dear "+ examination.getPatient().getFullName()+ ",\n\n"+ "The drug has been successfully reserved.\nStart time:"+
            startDate + "  " + startTime +",\n\nThank you for your trust!\n Pharmacy "+examination.getPharmacy().getName();
			emailService.sendNotificaitionAsync(examination.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
	public ExaminationDTO newExamination(Examination examination) throws Exception {
       if(!examinationRepository.isExaminationExistByDermatologist(examination.getStartTime(),examination.getEndTime(),examination.getDermatologist().getId()).isEmpty())
            return null;           
        if(!examinationRepository.isExaminationExistByPatient(examination.getStartTime(),examination.getEndTime(),examination.getPatient().getId()).isEmpty())
            return null;
        if(!counselingRepository.isCounselingExistByPatient(examination.getStartTime(),examination.getEndTime(),examination.getPatient().getId()).isEmpty())
            return null;
        if(!workTimeCheck(examination))
            return null;
		Examination e=new Examination();
        Double price=medicineService.Discount(examination.getPrice(), examination.getPatient().getId());
        e.setPrice(price);
        e.setDermatologist(dermatologistRepository.getOne(examination.getDermatologist().getId()));
        e.setPatient(patientRepository.getOne(examination.getPatient().getId()));
        e.setPharmacy(pharmacyRepository.getOne(examination.getPharmacy().getId()));
        e.setStartTime(examination.getStartTime());
        e.setEndTime(examination.getEndTime());
        ExaminationDTO examinationDTO= new ExaminationDTO(examinationRepository.save(e));
        LoyaltyProgramme lpDTO=loyaltyProgrammeService.findById(Long.valueOf(1));
        Patient patient =patientRepository.findById(examination.getPatient().getId()).get();
        patient.setPoints(patient.getPoints()+lpDTO.getPointsForExamination());
        patientService.update(patient);
        emailSender(e);
        return examinationDTO;
    }

	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public ExaminationDTO newEmptyExamination(Examination examination) throws Exception {          
        if(!checkIfDermatologistFree(examination)){
           return null;
        }
		Examination e=new Examination();
        e.setDermatologist(dermatologistRepository.getOne(examination.getDermatologist().getId()));
        e.setPatient(null);
        e.setIsCanceled(false);
        e.setIsDone(false);
        e.setPrice(examination.getPrice());
        e.setPharmacy(pharmacyRepository.getOne(examination.getPharmacy().getId()));
        e.setStartTime(examination.getStartTime());
        e.setEndTime(examination.getEndTime());
        ExaminationDTO examinationDTO= new ExaminationDTO(examinationRepository.save(e));
        emailSender(e);
        return examinationDTO;
    }

	public Set<DermatologistDTO> getDermatologistByPatientId(Long patientId) {
        Set<DermatologistDTO> dermatologists= new HashSet();
		List<ExaminationDTO> examinations=getAllExaminations();

		for (ExaminationDTO examinationDTO : examinations) {
			if(patientId==examinationDTO.getPatient().getId()){
				 dermatologists.add(examinationDTO.getDermatologist());
			}
		}	
        if(dermatologists.isEmpty()) return null;
        else return dermatologists;
	}

	public Set<PharmacyDTO> getPharmaciesByPatientId(Long patientId) {
        Set<PharmacyDTO> pharmaciesDTOs= new HashSet();
		List<ExaminationDTO> councelingDTOs=getAllExaminations();

		for (ExaminationDTO councelingDTO : councelingDTOs) {
			if(patientId==councelingDTO.getPatient().getId()){
				pharmaciesDTOs.add(councelingDTO.getPharmacy());
			}
		}
        if(pharmaciesDTOs.isEmpty()) return null;	
        else return pharmaciesDTOs;
	}

    // private Boolean isDermatologistWork(Examination examination) {
    //     for(WorkingTime w: examination.getDermatologist().getWorkingSchedule())
    //         if(examination.getStartTime().isAfter(w.getTimeStart()) || examination.getEndTime().isAfter(w.getTimeEnd()))
    //             return true;
    //     return false;
    // }
    
    private Boolean workTimeCheck(Examination examination){
        Dermatologist d = dermatologistRepository.getOne(examination.getDermatologist().getId());
        Set<WorkingTime> workingTime= d.getWorkingScheduleByPharmacyId(examination.getPharmacy().getId());
        for(WorkingTime w: workingTime)
            if(examination.getStartTime().compareTo(w.getTimeStart()) > 0 && w.getTimeEnd().compareTo(examination.getStartTime())>0
                && w.getTimeEnd().compareTo(examination.getEndTime())>0 && examination.getEndTime().compareTo(w.getTimeStart())>0)
                return true;
        return false;
    }

	
    private Boolean checkIfDermatologistFree(Examination examination) {
        if(workTimeCheck(examination)){
            List<Examination> examinations = examinationRepository.getExaminationsByDermatologistId(examination.getDermatologist().getId());
            for(Examination ex: examinations){
                if(examination.getStartTime().isBefore(ex.getStartTime()) && examination.getEndTime().isAfter(ex.getEndTime()) ||
                examination.getStartTime().isAfter(ex.getStartTime()) && examination.getEndTime().isBefore(ex.getEndTime()) ||
                examination.getStartTime().isAfter(ex.getStartTime()) && examination.getEndTime().isAfter(ex.getEndTime()) && examination.getStartTime().isBefore(ex.getEndTime()) ||
                examination.getStartTime().isBefore(ex.getStartTime()) && examination.getEndTime().isAfter(ex.getStartTime()) ||
                examination.getStartTime().isEqual(ex.getStartTime()) ||
                examination.getEndTime().isEqual(ex.getEndTime())
                )
                    return false;
            }
            return true;
        }
        return false;
    }



    private void emailSender(Examination examination)
	{
		try {
			String subject="Examination "+ examination.getStartTime()+" " +examination.getEndTime();
			String text="Dear "+ examination.getPatient().getFullName()+",\nThank you for your trust!\n\n!"+examination.getDermatologist().getFullName();
			emailService.sendNotificaitionAsync(examination.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	public List<ExaminationDTO> getExaminationsByDermatologist(Long id) {
		List<ExaminationDTO> examinationDTOs=new ArrayList<ExaminationDTO>();

		for (Examination examination : examinationRepository.getExaminationsExistByDermatologist(id))
                    examinationDTOs.add(new ExaminationDTO(examination));
        return examinationDTOs;
	}

    public List<ExaminationDTO> getFreeExamination(){
        List<ExaminationDTO> examinationDTOs=new ArrayList<ExaminationDTO>();

		for (Examination examination : examinationRepository.getFreeExamination()){
        int i = examination.getStartTime().compareTo(LocalDateTime.now());
            if(i > 0)
                    examinationDTOs.add(new ExaminationDTO(examination));
        }
        return examinationDTOs;
    }
    
	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
	public Examination notCome(Examination examination) {
		Examination e=examinationRepository.getOne(examination.getId());
        e.setReport(examination.getReport());
        e.setIsDone(false);
        return examinationRepository.save(e);
	}

    public List<ExaminationDTO> getUpcomingExaminationsByDermatologistAndPharmacy(Long pharmacyId,Long dermatologistId){
        List<ExaminationDTO> examinationDTOs = new ArrayList<ExaminationDTO>();
        List<Examination> examinations = examinationRepository.getUpcomingExaminationsByDermatologistAndPharmacy(pharmacyId,dermatologistId);


        for(Examination ex : examinations){
            examinationDTOs.add(new ExaminationDTO(ex));
        }

        return examinationDTOs;
    }


	public List<MedicineGraphInfo> examiantionsDaily(Long pharmacyId, int month , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			for(int i = 0 ; i < 31 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			for(int i = 0 ; i < 30 ; i++){
				retVal.add(new MedicineGraphInfo(i,0));	
			}
		}
		else if(month == 2){
			for(int i = 0 ; i < 29 ; i++){
				retVal.add(new MedicineGraphInfo(i,0));	
			}
		}

		List<Examination> examinations = pharmacyRepository.getFinishedExaminations(pharmacyId);
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			for(int i = 0 ; i < 31 ; i++){
				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			for(int i = 0 ; i < 30 ; i++){
				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		else if(month == 2){
			for(int i = 0 ; i < 29 ; i++){
				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		return retVal;
	}

	public List<MedicineGraphInfo> examinationQuartal(Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		for(int i = 0 ; i < 4 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
		}


		List<Examination> examinations = pharmacyRepository.getFinishedExaminations(pharmacyId);

				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& ( Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 1 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 2 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 3 )
					){
						retVal.get(0).incrementY();
					}
					else if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& (Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 4 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 5 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 6 )
					){
						retVal.get(1).incrementY();
					}
					else if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& (Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 7 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 8 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 9 )
					){
						retVal.get(2).incrementY();
					}
					else if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& (Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 10 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 11 
					|| Integer.parseInt(r.getEndTime().toString().split("-")[1]) == 12 )
					){
						retVal.get(3).incrementY();
					}
				}
			
		return retVal;
	}

	public List<MedicineGraphInfo> examinationMonthly(Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		for(int i = 0 ; i < 12 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
		}


		List<Examination> examinations = pharmacyRepository.getFinishedExaminations(pharmacyId);
		for(int i = 0 ; i < 12 ; i++){
				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getEndTime().toString().split("-")[1]) == i+1 
					){
						retVal.get(i).incrementY();
					}
				}
			}
			
		return retVal;
	}
	
	public List<MedicineGraphInfo> examinationYearly(Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
        year = year- 4;

		for(int i = 0 ; i < 5 ; i++){
				retVal.add(new MedicineGraphInfo(year + i,0));	
		}


		List<Examination> examinations = pharmacyRepository.getFinishedExaminations(pharmacyId);
		for(int i = 0 ; i < 5 ; i++){
				for(Examination r : examinations){
					if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year + i 
					){
						retVal.get(i).incrementY();
					}
				}
			}
			
		return retVal;
	}
}