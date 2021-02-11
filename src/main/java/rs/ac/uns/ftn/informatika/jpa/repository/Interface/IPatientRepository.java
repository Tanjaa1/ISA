package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;


public interface IPatientRepository extends JpaRepository<Patient, Long>{

	@Override
	public Patient getOne(Long id);
	@Override
	public <S extends Patient> S save(S entity);
	
	Optional<Patient> findById(Long id);

    @Query("SELECT distinct p FROM Examination u,Dermatologist d,Patient p WHERE u.Dermatologist=d.Id and u.Patient=p.Id and d.Id = ?1")
	List<Patient> findPatientsByDermatologist(Long id);
	
    @Query("SELECT distinct p FROM Counseling u,Pharmacist d,Patient p WHERE u.Pharmacist=d.Id and u.Patient=p.Id and d.Id = ?1")
	List<Patient> findPatientsByPharmacist(Long id);

	@Query("SELECT distinct patients FROM Pharmacy u JOIN u.SubscribedUsers patients WHERE u.Id = ?1")
	List<Patient> findPatientsSubscribed(Long pharmacyId);
}
