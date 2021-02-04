package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;


public interface IPatientRepository extends JpaRepository<Patient, Long>{

	@Override
	public Patient getOne(Long id);
	@Override
	public <S extends Patient> S save(S entity);

	
}
