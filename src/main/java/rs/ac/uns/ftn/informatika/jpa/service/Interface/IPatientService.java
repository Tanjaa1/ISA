package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

public interface IPatientService {

	Patient update(Patient greeting) throws Exception;
	public ResponseEntity<Patient> save(Patient patient) throws Exception;
	public Patient findOne(Long id);
	public Patient findById(Long id);
	List<PatientDTO> getAllPatients();
	public PatientDTO findByIdComplaints(Long id);
	List<PatientDTO> findPatientsByDermatologist(Long id);
	List<PatientDTO> findPatientsByPharmacist(Long id);
	List<PatientDTO> findPatientsByNameAndSurnameDermatologist(Long id,String name,String surname);
	List<PatientDTO> findPatientsByNameAndSurnamePharmacist(Long id,String name,String surname);
	List<Patient>  findSubscribetPatients (Long pharmacyId);

}
