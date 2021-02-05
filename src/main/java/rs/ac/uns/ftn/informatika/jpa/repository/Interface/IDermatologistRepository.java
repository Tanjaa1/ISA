package rs.ac.uns.ftn.informatika.jpa.repository.Interface;


import java.util.ArrayList;


import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;


import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
public interface IDermatologistRepository extends JpaRepository<Dermatologist, Long>{

	@Override
	public Dermatologist getOne(Long id);
	@Override
	public <S extends Dermatologist> S save(S entity);
  
  	ArrayList<Dermatologist> findAll();
}
