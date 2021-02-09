package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IExaminationService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Service
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

    public List<Examination> findFutureExaminationsByPatientId(Long id) {
        List<Examination> patientExaminations = new ArrayList<>();
        List<Examination> examinations = examinationRepository.findAll();
        for (Examination examination : examinations) {
            int i = examination.getStartTime().compareTo(LocalDateTime.now());
            if (examination.getPatient() != null && id == examination.getPatient().getId() && i > 0) {
                patientExaminations.add(examination);
            }
        }
        return patientExaminations;
    }

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

	public Examination schedule(Examination examination) throws Exception{
        Examination e=examinationRepository.getOne(examination.getId());
        e.setPatient(patientRepository.getOne(examination.getPatient().getId()));
        return examinationRepository.save(e);
	}

	public ExaminationDTO newExamination(Examination examination) throws Exception {
        if(!examinationRepository.isExaminationExistByDermatologist(examination.getStartTime(),examination.getEndTime(),examination.getDermatologist().getId()).isEmpty())
            return null;           
        if(!examinationRepository.isExaminationExistByPatient(examination.getStartTime(),examination.getEndTime(),examination.getPatient().getId()).isEmpty())
            return null;
        if(!counselingRepository.isCounselingExistByPatient(examination.getStartTime(),examination.getEndTime(),examination.getPatient().getId()).isEmpty())
            return null;
        if(!isDermatologistWork(examination))
            return null;
		Examination e=new Examination();
        e.setDermatologist(dermatologistRepository.getOne(examination.getDermatologist().getId()));
        e.setPatient(patientRepository.getOne(examination.getPatient().getId()));
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

    private Boolean isDermatologistWork(Examination examination) {
        for(WorkingTime w: examination.getDermatologist().getWorkingSchedule())
            if(examination.getStartTime().isAfter(w.getTimeStart()) || examination.getEndTime().isAfter(w.getTimeEnd()))
                return true;
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
}