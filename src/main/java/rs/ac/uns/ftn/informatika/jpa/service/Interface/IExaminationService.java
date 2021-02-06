package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
    List<Examination> findPastExaminationsByPatientId(Long id);
    List<Examination> findFutureExaminationsByPatientId(Long id);
	Examination update(Long id) throws Exception;
    Examination getExaminationById(Long id);
}
