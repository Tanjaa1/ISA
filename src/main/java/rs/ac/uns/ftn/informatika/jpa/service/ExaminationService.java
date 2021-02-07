package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IExaminationService;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    private IExaminationRpository examinationRepository;

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
}