package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

public interface IPatientService {

	Patient update(Patient greeting) throws Exception;
	public ResponseEntity<Patient> save(Patient patient) throws Exception;
	public Patient findOne(Long id);


}
