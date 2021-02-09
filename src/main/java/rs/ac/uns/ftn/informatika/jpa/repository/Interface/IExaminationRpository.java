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
}
