package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.PatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPatientService;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;
	
	public Patient findOne(Long id) {
		 Patient patient = patientRepository.getOne(id);
	        return patient;
	}
}
