package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

    @Autowired
	private ICounselingRpository counselingRepository;

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

    public List<Counseling> findFutureCounselingsByPatientId(Long id) {
        List<Counseling> patientCounselings = new ArrayList<>();
        List<Counseling> counselings = counselingRepository.findAll();
        for (Counseling counseling : counselings) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now());
           if(id == counseling.getPatient().getId() && i > 0){
                patientCounselings.add(counseling);
            }
       }
       return patientCounselings;
	}

	public Counseling update(long id)throws Exception 
    {
            Counseling e=counselingRepository.getOne(id);
            e.setIsDone(true);
            return counselingRepository.save(e);
	} 
}
