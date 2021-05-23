package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.PatientService;

@RestController
@RequestMapping(value = "/patient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	
	
	@Autowired
	private PatientService patientService;

	
	@GetMapping(value = "/getPatientById/{id}")
	public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
		PatientDTO patient = new PatientDTO(patientService.findOne(id));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/getPatientByIdd/{id}")
	public ResponseEntity<PatientDTO> getPatientByIdd(@PathVariable Long id) {
		PatientDTO patient = new PatientDTO(patientService.findById(id));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/getPatientByCredentials/{username}")
	public ResponseEntity<PatientDTO> getPatientByCredentials(@PathVariable String username) {
		PatientDTO patient = new PatientDTO(patientService.getPatientByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<PatientDTO> updateGreeting(@RequestBody Patient patient) throws Exception {	
		//patientService.update(patient);
		PatientDTO p = new PatientDTO(patientService.update(patient));
		return p == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(p);
	}

	@GetMapping(value = "/getPatientByDermatologistExamination/{id}")
	public ResponseEntity<List<PatientDTO>> getPatientByExamination(@PathVariable Long id) 
	{
		List<PatientDTO> patients=patientService.findPatientsByDermatologist(id);
		return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/getPatientByPharmacistCouseling/{id}")
	public ResponseEntity<List<PatientDTO>> getPatientByPharmacistCouseling(@PathVariable Long id) 
	{
		List<PatientDTO> patients=patientService.findPatientsByPharmacist(id);
		return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/getPatientByDermatologistExaminationSearch/{id}/{name}/{surname}")
	public ResponseEntity<List<PatientDTO>> getPatientByExaminationSearch(@PathVariable Long id,
											@PathVariable String name,@PathVariable String surname) 
	{
		List<PatientDTO> patients=patientService.findPatientsByNameAndSurnameDermatologist(id,name,surname);
		return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/getPatientByPharmacistCounselingSearch/{id}/{name}/{surname}")
	public ResponseEntity<List<PatientDTO>> getPatientByCounselingSearch(@PathVariable Long id,
											@PathVariable String name,@PathVariable String surname) 
	{
		List<PatientDTO> patients=patientService.findPatientsByNameAndSurnamePharmacist(id,name,surname);
		return patients == null? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}
	@GetMapping(value = "/getAllPatients")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients=patientService.getAllPatients();
		return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/findByIdComplaints/{id}")
	public PatientDTO findByIdComplaints(@PathVariable Long id) {
		PatientDTO patient=patientService.findByIdComplaints(id);
		return patient;
	}


	@PostMapping(value = "/savePatient")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patientDTO) throws Exception{
		patientService.save(patientDTO);
	return new ResponseEntity<>(patientDTO, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/savePatientDrugAllergies/{drugAl}")
	public List<String> saveDrugAll(@PathVariable String drugAl) throws Exception{
		List<String> setDrugAl=patientService.saveDrugAll(drugAl);
	return setDrugAl;
	}

	@GetMapping(value = "/getAllPatientUsernames")
	public ResponseEntity<List<String>> getAllPatientUsernames() {
		List<String> usernames =patientService.getAllPatientUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}

	@PutMapping(value ="/confirmationEmail/{patientId}")
	public ResponseEntity<Boolean> confirmationEmail(@PathVariable String patientId) throws Exception {
		Boolean success = patientService.confirmationEmail(Long.parseLong(patientId));
		return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	}

	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = patientService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@GetMapping(value = "/getEPharmaciesByPatientIdAndPrescriptions/{patientId}")
	public ResponseEntity<Set<PharmacyDTO>> getEPharmaciesByPatientIdAndPrescriptions( @PathVariable Long patientId) throws Exception
	{
		Set<PharmacyDTO> pharmacies =patientService.getEPharmaciesByPatientIdAndPrescriptions(patientId);
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}


	@PostMapping(value = "/saveActionOrPromotion/{patientId}")
	public ActionOrPromotionsDTO saveActionOrPromotion(@PathVariable String patientId,@RequestBody ActionOrPromotionsDTO actionOrPromotionsDTO) throws Exception{
		ActionOrPromotionsDTO saveActionOrPromotion=patientService.saveActionOrPromotion(patientId,actionOrPromotionsDTO);
	return saveActionOrPromotion;
	}

	@GetMapping(value = "/cancelActionOrPromotion/{idPatient}/{idAction}")
	public ActionOrPromotionsDTO calcelActionOrPromotion(@PathVariable String idPatient,@PathVariable String idAction) throws Exception{
		ActionOrPromotionsDTO canceledActionOrPromotion=patientService.cancelActionOrPromotion(idPatient,idAction);
	return canceledActionOrPromotion;
	}

	@GetMapping(value = "/getAllActionsAndPromotionByPatientId/{patientId}")
	public ResponseEntity<Set<ActionOrPromotionsDTO>> getAllActionsAndPromotionByPatientId(@PathVariable String patientId) {
		Set<ActionOrPromotionsDTO> actionOrPromotionsDTOs =patientService.getAllActionsAndPromotionByPatientId(patientId);
		return actionOrPromotionsDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(actionOrPromotionsDTOs);
	}
}
