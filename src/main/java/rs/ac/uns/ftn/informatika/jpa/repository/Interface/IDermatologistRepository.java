package rs.ac.uns.ftn.informatika.jpa.repository.Interface;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDermatologistRepository extends JpaRepository<Dermatologist, Long>{

	@Override
	public Dermatologist getOne(Long id);
	@Override
	public <S extends Dermatologist> S save(S entity);
  	ArrayList<Dermatologist> findAll();
	  
	  @Query("SELECT distinct d FROM Dermatologist d,Examination e,Patient p WHERE e.Dermatologist=d.Id and e.Patient=p.Id and p.Id=?1")
	  public List<Dermatologist> getDermatologists(Long id);

	  	  
	  @Query("SELECT distinct d FROM Dermatologist d WHERE  d.Id=?1")
	  public Dermatologist getOneById(Long id);
}
