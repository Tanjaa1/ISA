package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;

@RestController
@RequestMapping(value = "/examination")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExaminationController {
    
    @Autowired
	private ExaminationService examinationService;
	
	@GetMapping(value = "/getPastExaminationByPatientId/{id}")
	public ResponseEntity<List<ExaminationDTO>> getPastExaminationByPatientId(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = new ArrayList<ExaminationDTO>();
		List<Examination> examinations = examinationService.findPastExaminationsByPatientId(id);
		for (Examination examination : examinations) {
			examinationDTOs.add(new ExaminationDTO(examination));
		}
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

    @GetMapping(value = "/getFutureExaminationByPatientId/{id}")
	public ResponseEntity<List<ExaminationDTO>> getFutureExaminationByPatientId(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = new ArrayList<ExaminationDTO>();
		List<Examination> examinations = examinationService.findFutureExaminationsByPatientId(id);
		for (Examination examination : examinations) {
			examinationDTOs.add(new ExaminationDTO(examination));
		}
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@PutMapping(value = "/finish")
	public ResponseEntity<HttpStatus> update(@RequestBody Examination examination) throws Exception
	{
		Examination e =examinationService.finish(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getExaminationById/{id}")
	public ResponseEntity<Examination> getExaminationById(@PathVariable Long id) 
	{
		Examination examination = examinationService.getExaminationById(id);
		return examination == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examination);
	}
	@GetMapping(value = "/getAllExaminations")
	public List<ExaminationDTO> getAllExaminations() {
		List<ExaminationDTO> examinations =examinationService.getAllExaminations();
		return examinations;
	}

	@GetMapping(value = "/getDermatologistByPatientId/{patientId}") 
	public ResponseEntity<Set<DermatologistDTO>> getDermatologistByPatientId(@PathVariable Long patientId) throws Exception 
	{
		Set<DermatologistDTO> dermatologists=examinationService.getDermatologistByPatientId(patientId);
		return dermatologists == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(dermatologists);
	}

	@GetMapping(value = "/getPharmaciesByPatientId/{patientId}") 
	public ResponseEntity<Set<PharmacyDTO>> getPharmaciesByPatientId(@PathVariable Long patientId) throws Exception 
	{
		Set<PharmacyDTO> pharmacies=examinationService.getPharmaciesByPatientId(patientId);
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}

	@GetMapping(value = "/getFreeExaminationByDermatologist/{id}")
	public ResponseEntity<List<ExaminationDTO>> getFreeExaminationByDermatologist(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getFreeExaminationByDermatologist(id);
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@PutMapping(value = "/schedule")
	public ResponseEntity<List<ExaminationDTO>> getFreeExaminationByDermatologist(@RequestBody Examination examination)
		throws Exception 
	{
		Examination e =examinationService.schedule(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<ExaminationDTO> newExamination(@RequestBody Examination examination)
		throws Exception 
	{
		return ResponseEntity.ok(examinationService.newExamination(examination));
	}

	@PostMapping(value = "/addEmptyExamination")
	public ResponseEntity<ExaminationDTO> newEmptyExamination(@RequestBody Examination examination)
		throws Exception 
	{
		return ResponseEntity.ok(examinationService.newEmptyExamination(examination));
	}

	@PutMapping(value = "/cancelExamination")
	public ResponseEntity<HttpStatus> cancelExamination(@RequestBody Examination examination) throws Exception
	{
		Examination e =examinationService.updateExamination(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	
	@GetMapping(value = "/getExaminationsByDermatologist/{id}")
	public ResponseEntity<List<ExaminationDTO>> getExaminationsByDermatologist(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getExaminationsByDermatologist(id);
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}
}
