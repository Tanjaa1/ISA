package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IExaminationService;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    private IExaminationRpository examinationRepository;
    
    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDermatologistRepository dermatologistRepository;

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

    public Examination update(Long id) throws Exception {
        Examination e=examinationRepository.getOne(id);
        e.setIsDone(true);
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
}