package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;


public interface IPatientRepository extends JpaRepository<Patient, Long>{

	@Override
	public Patient getOne(Long id);
	@Override
	public <S extends Patient> S save(S entity);
	@Override
	Optional<Patient> findById(Long id);
	
	
}
