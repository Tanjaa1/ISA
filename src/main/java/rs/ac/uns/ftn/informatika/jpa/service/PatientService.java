package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPatientService;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;
	
	@Autowired
	private IExaminationRpository examinationRepository;

	public Patient findOne(Long id) {
		 Patient patient = patientRepository.getOne(id);
	        return patient;
	}

	@Override
    public Patient update(Patient patient) throws Exception {
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
        return patient2;
    }
	public List<PatientDTO> findPatients(Long id) {
		List<Examination> examinations = examinationRepository.findAll();
		List<PatientDTO> patients=new ArrayList<PatientDTO>();
		for (Examination examination : examinations)
			if(examination.getDermatologist().getId()==id)
			   patients.add(new PatientDTO(examination.getPatient()));
		return patients;
   }

	public List<PatientDTO> findPatientsByNameAndSurname(Long id,String name,String surname) {	
		List<PatientDTO> patients=new ArrayList<PatientDTO>();
		for (PatientDTO patientDTO : findPatients(id)) {
			if(patientDTO.containsNameAndSurname(name,surname))
				patients.add(patientDTO);
		}
		return patients;
	}


	public ResponseEntity<Patient> save(Patient patient) throws Exception{
		patientRepository.save(patient);
	return new ResponseEntity<>( HttpStatus.CREATED);
	}

	public List<String> saveDrugAll( String drugAllergies) throws Exception{
		String drugAllergiesParts[]=drugAllergies.split(",");
		List<String> listdrugAllergies=new ArrayList<String>();
		for(String  i : drugAllergiesParts){
			listdrugAllergies.add(i);
		}	
	return listdrugAllergies;
	}
	public List<String> getAllPatientUsernames() {
		List<Patient> patients = patientRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Patient s : patients) {
            resultList.add(s.getUsername());
        }
        return resultList;
	}
	public Boolean isUsernameValid(String username) {
		List<String> usernames=getAllPatientUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}


	
}
