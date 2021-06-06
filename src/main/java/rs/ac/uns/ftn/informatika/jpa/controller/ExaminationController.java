package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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
import rs.ac.uns.ftn.informatika.jpa.util.MedicineGraphInfo;

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
		List<ExaminationDTO> examinations = examinationService.findFutureExaminationsByPatientId(id);
		for (ExaminationDTO examination : examinations) {
			examinationDTOs.add(examination);
		}
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@PutMapping(value = "/finish")
	public ResponseEntity<HttpStatus> update(@Valid @RequestBody Examination examination, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@GetMapping(value = "/getFreeExaminationByDermatologist/{id}")
	public ResponseEntity<List<ExaminationDTO>> getFreeExaminationByDermatologist(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getFreeExaminationByDermatologist(id);
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PATIENT')")
	@PutMapping(value = "/schedule")
	public ResponseEntity<List<ExaminationDTO>> getFreeExaminationByDermatologist(@Valid @RequestBody Examination examination, BindingResult result)
		throws Exception 
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		ExaminationDTO e =examinationService.schedule(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@PostMapping(value = "/add")
	public ResponseEntity<ExaminationDTO> newExamination(@Valid @RequestBody Examination examination, BindingResult result)
		throws Exception 
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(new ExaminationDTO(),HttpStatus.BAD_REQUEST);
		ExaminationDTO e =examinationService.newExamination(examination);
			return e == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(e,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PostMapping(value = "/addEmptyExamination")
	public ResponseEntity<ExaminationDTO> newEmptyExamination(@Valid @RequestBody Examination examination, BindingResult result)
		throws Exception 
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(new ExaminationDTO(),HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(examinationService.newEmptyExamination(examination));
	}

	@PutMapping(value = "/cancelExamination")
	public ResponseEntity<HttpStatus> cancelExamination(@Valid @RequestBody Examination examination, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Examination e =examinationService.updateExamination(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@GetMapping(value = "/getExaminationsByDermatologist/{id}")
	public ResponseEntity<List<ExaminationDTO>> getExaminationsByDermatologist(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getExaminationsByDermatologist(id);
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@GetMapping(value = "/getFreeExaminations")
	public ResponseEntity<List<ExaminationDTO>> getFreeExaminations() 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getFreeExamination();
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}
	
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@PutMapping(value = "/notCome")
	public ResponseEntity<HttpStatus> notCome(@Valid @RequestBody Examination examination, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Examination e =examinationService.notCome(examination);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT')")
	@GetMapping(value = "/getUpcomingFreeExaminations/{idP}/{idD}")
	public ResponseEntity<List<ExaminationDTO>> getWorkingTimes(@PathVariable Long  idP,@PathVariable Long idD) 
	{
		List<ExaminationDTO> examinationDTOs = examinationService.getUpcomingExaminationsByDermatologistAndPharmacy(idP,  idD);
		return examinationDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationDTOs);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/ExaminationsDaily/{pharmacyID}/{month}/{year}")
	public ResponseEntity<List<MedicineGraphInfo>> examinationDaily(@PathVariable Long pharmacyID,@PathVariable int month,@PathVariable int year) throws Exception {
	List<MedicineGraphInfo> retVal = examinationService.examiantionsDaily(pharmacyID,month,year);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/ExaminationsMonthly/{pharmacyID}/{year}")
	public ResponseEntity<List<MedicineGraphInfo>> examinationMonthly(@PathVariable Long pharmacyID,@PathVariable int year) throws Exception {
	List<MedicineGraphInfo> retVal = examinationService.examinationMonthly(pharmacyID,year);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/ExaminationsYearly/{pharmacyID}/{year}")
	public ResponseEntity<List<MedicineGraphInfo>> examinationYearly(@PathVariable Long pharmacyID,@PathVariable int year) throws Exception {
	List<MedicineGraphInfo> retVal = examinationService.examinationYearly(pharmacyID,year);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/ExaminationsQuartaly/{pharmacyID}/{year}")
	public ResponseEntity<List<MedicineGraphInfo>> examinationsQuartaly(@PathVariable Long pharmacyID,@PathVariable int year) throws Exception {
	List<MedicineGraphInfo> retVal = examinationService.examinationQuartal(pharmacyID,year);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}


}
