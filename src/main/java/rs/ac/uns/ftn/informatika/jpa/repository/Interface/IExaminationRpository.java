package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;


public interface IExaminationRpository extends JpaRepository<Examination, Long> {
	@Override
	public List<Examination> findAll();
	@Override
	public Examination getOne(Long id);
	@Override
	public <S extends Examination> S save(S entity);
	
    @Query("SELECT u FROM Examination u,Dermatologist d WHERE u.Dermatologist=d.Id and d.Id = ?1 and u.Patient=null")
    public List<Examination> getFreeExaminationByDermatologist(Long d);

	
    @Query
	("SELECT u FROM Examination u,Dermatologist d WHERE u.Dermatologist=d.Id and d.Id = ?3 and (?1  between u.StartTime and u.EndTime) or (?2 between u.StartTime and u.EndTime)")
    public List<Examination> isExaminationExistByDermatologist(LocalDateTime start,LocalDateTime end,Long id);
	
    @Query
	("SELECT u FROM Examination u,Patient d WHERE u.Patient=d.Id and d.Id = ?3 and (?1  between u.StartTime and u.EndTime) or (?2 between u.StartTime and u.EndTime)")
    public List<Examination> isExaminationExistByPatient(LocalDateTime start,LocalDateTime end,Long id);


	@Query
	("SELECT ex from Examination ex ,Dermatologist d WHERE d.Id = ?1 and ex.Dermatologist = d.Id")
    public List<Examination> getExaminationsByDermatologistId(long dermatologistId);

    @Query("SELECT u FROM Examination u,Dermatologist d WHERE u.Dermatologist=d.Id and d.Id = ?1")
    public List<Examination> getExaminationsExistByDermatologist(Long id);


	@Query("SELECT u FROM Examination u,Dermatologist d WHERE u.Dermatologist=d.Id and u.Patient=null")
    public List<Examination> getFreeExamination();

	@Query("SELECT u FROM Examination u , Dermatologist d , Pharmacy p WHERE u.Pharmacy= p.Id and u.Dermatologist= d.Id and p.Id = ?1 and d.Id = ?2 and u.StartTime >= CURRENT_DATE and u.Patient is null ")
    public List<Examination> getUpcomingExaminationsByDermatologistAndPharmacy(Long pID, Long dID);

	@Query("SELECT u FROM Examination u , Dermatologist d , Pharmacy p WHERE u.Pharmacy= p.Id and u.Dermatologist= d.Id and p.Id = ?1 and d.Id = ?2 and u.StartTime >= CURRENT_DATE and u.IsCanceled = false ")
    public List<Examination> checkForDelete(Long pID, Long dID);

}
