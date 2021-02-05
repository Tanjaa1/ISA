package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistRepository extends JpaRepository<Pharmacist, Long>{

	@Override
	public Pharmacist getOne(Long id);
	@Override
	public <S extends Pharmacist> S save(S entity);
	
	ArrayList<Pharmacist> findAll();

}
