package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
    public List<Examination> findPastExaminationsByPatientId(Long id);
    public List<Examination> findFutureExaminationsByPatientId(Long id);
}
