package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
    List<Examination> findPastExaminationsByPatientId(Long id);
    List<ExaminationDTO> findFutureExaminationsByPatientId(Long id);
	Examination finish(Examination examination) throws Exception;
    Examination getExaminationById(Long id);
    List<ExaminationDTO> getFreeExaminationByDermatologist(Long id);
    ExaminationDTO schedule(Examination examination) throws Exception;
    ExaminationDTO newExamination(Examination examination) throws Exception;
    List<ExaminationDTO> getExaminationsByDermatologist(Long id);
}
