package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;

public interface ICounselingService {
    public List<Counseling> findPastCounselingsByPatientId(Long id);
    public List<CouncelingDTO> findFutureCounselingsByPatientId(Long id);
    CouncelingDTO newCounseling(Counseling counseling) throws Exception;
    Counseling finish(Counseling counseling)throws Exception;
}
