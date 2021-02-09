package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;

public interface ICounselingService {
    public List<Counseling> findPastCounselingsByPatientId(Long id);
    public List<Counseling> findFutureCounselingsByPatientId(Long id);
    CouncelingDTO newExamination(Counseling counseling) throws Exception;
}
