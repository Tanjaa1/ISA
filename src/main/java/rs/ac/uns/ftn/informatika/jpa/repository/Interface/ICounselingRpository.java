package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;

public interface ICounselingRpository extends JpaRepository<Counseling, Long> {
    @Override
	public List<Counseling> findAll();
    
    @Query
	("SELECT u FROM Counseling u,Patient d WHERE u.Patient=d.Id and d.Id = ?3 and (?1  between u.StartTime and u.EndTime) or (?2 between u.StartTime and u.EndTime)")
    public List<Counseling> isCounselingExistByPatient(LocalDateTime start,LocalDateTime end,Long id);
    
    @Query
	("SELECT u FROM Counseling u,Pharmacist d WHERE u.Pharmacist=d.Id and d.Id = ?3 and (?1  between u.StartTime and u.EndTime) or (?2 between u.StartTime and u.EndTime)")
    public List<Counseling> isExaminationExistByPharmacist(LocalDateTime start,LocalDateTime end,Long id);

    
    @Query("SELECT u FROM Counseling u,Pharmacist d WHERE u.Pharmacist=d.Id and d.Id = ?1")
	public List<Counseling> getCounselingByPharmacist(Long id);

    @Query
	("SELECT c FROM Counseling c,Pharmacist p WHERE c.Pharmacist=p.Id and p.Id = ?2 and ?1 < c.EndTime ")
    public List<Counseling> checkIfCounselingExists(LocalDateTime now,Long id);

    @Query("SELECT c FROM Counseling c ,Pharmacist p WHERE c.Pharmacist = p.Id and p.Id = ?1  and  c.StartTime >= CURRENT_DATE and c.IsCanceled = false ")
    public List<Counseling> getUpcomingCounselingByPharmacist(Long pID);
}
