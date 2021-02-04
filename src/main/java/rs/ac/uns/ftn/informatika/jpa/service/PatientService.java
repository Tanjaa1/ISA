package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;
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

	@Override
    public void update(Patient patient) throws Exception {
        Patient patient1 = findOne(patient.getId());
        if (patient1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		patient1.setId(patient.getId());
		patient1.setName(patient.getName());
		patient1.setSurname(patient.getSurname());
		patient1.setEmail(patient.getEmail());
		patient1.setPassword(patient.getPassword());
		patient1.setAddress(patient.getAddress());
		patient1.setCity(patient.getCity());
		patient1.setCountry(patient.getCountry());
		patient1.setPhoneNumber(patient.getPhoneNumber());
		patient1.setCategory(patient.getCategory());
		patient1.setPoints(patient.getPoints());
		patient1.setPenalty(patient.getPenalty());
		patient1.setEmailComfirmed(patient.getEmailComfirmed());
		patient1.setFirstTimeLogin(patient.getFirstTimeLogin());
		patient1.setDescription(patient.getDescription());
		patient1.setDrugAllargies(patient.getDrugAllargies());
        Patient patient2 = patientRepository.save(patient1);
        //return patient2;
    }
}
