package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;


public interface IExaminationRpository extends JpaRepository<Examination, Long> {

    // @Query("select * from public.examination")
	// List<Examination> findAllByDermatologistId(Long dermatologist_id);
}
