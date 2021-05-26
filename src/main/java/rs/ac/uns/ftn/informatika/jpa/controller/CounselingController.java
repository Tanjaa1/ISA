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

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.service.CounselingService;

@RestController
@RequestMapping(value = "/counseling")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CounselingController {
 
    @Autowired
	private CounselingService counselingService;
	
	@GetMapping(value = "/getPastCounselingByPatientId/{id}")
	public ResponseEntity<List<CouncelingDTO>> getPastCounselingByPatientId(@PathVariable Long id) {
		List<CouncelingDTO> counselingsDTO = new ArrayList<CouncelingDTO>();
		List<Counseling> counselings = counselingService.findPastCounselingsByPatientId(id);
		for (Counseling counseling : counselings) {
			counselingsDTO.add(new CouncelingDTO(counseling));
		}
		return counselingsDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(counselingsDTO);
	}

    @GetMapping(value = "/getFutureCounselingByPatientId/{id}")
	public ResponseEntity<List<CouncelingDTO>> getFutureCounselingByPatientId(@PathVariable Long id) {
		List<CouncelingDTO> counselingsDTO = new ArrayList<CouncelingDTO>();
		List<CouncelingDTO> counselings = counselingService.findFutureCounselingsByPatientId(id);
		for (CouncelingDTO counseling : counselings) {
			counselingsDTO.add(counseling);
		}
		return counselingsDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(counselingsDTO);
	}

	@PreAuthorize("hasAnyRole('PHARMACIST','PHARMACYADMIN')")
	@PutMapping(value = "/finish")
	public ResponseEntity<HttpStatus> update(@Valid @RequestBody Counseling counseling, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Counseling e =counselingService.finish(counseling);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getAllExaminations")
	public List<CouncelingDTO> getAllCounselings() {
		List<CouncelingDTO> councelingDTOs =counselingService.getAllCounselings();
		return councelingDTOs;
	}

	@GetMapping(value = "/getPharmacistsByPatientId/{patientId}") 
	public ResponseEntity<Set<PharmacistDTO>> getPharmacisstByPatientId(@PathVariable Long patientId) throws Exception 
	{
		Set<PharmacistDTO> pharmacistDTOs=counselingService.getPharmacisstByPatientId(patientId);
		
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@GetMapping(value = "/getPharmaciesByPatientId/{patientId}") 
	public ResponseEntity<Set<PharmacyDTO>> getPharmaciesByPatientId(@PathVariable Long patientId) throws Exception 
	{
		Set<PharmacyDTO> pharmacistDTOs=counselingService.getPharmaciesByPatientId(patientId);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@PutMapping(value = "/cancelCounseling")
	public ResponseEntity<HttpStatus> cancelCounseling(@Valid @RequestBody Counseling counseling, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Counseling e =counselingService.updateCounseling(counseling);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('PHARMACIST')")
	@PostMapping(value = "/add")
	public ResponseEntity<CouncelingDTO> newExamination(@Valid @RequestBody Counseling counseling, BindingResult result)
		throws Exception 
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(new CouncelingDTO(),HttpStatus.BAD_REQUEST);
		CouncelingDTO e =counselingService.newCounseling(counseling);
		return e == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(e,HttpStatus.OK);
	}

	@PostMapping(value = "/createCounseling")
	public ResponseEntity<CouncelingDTO> createCounseling(@RequestBody Counseling counseling, BindingResult result)
		throws Exception 
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(new CouncelingDTO(),HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(counselingService.createNewCounseling(counseling));
	}

	@GetMapping(value = "/getCounselingByPharmacist/{id}")
	public ResponseEntity<List<CouncelingDTO>> getCounselingByPharmacist(@PathVariable Long id) 
	{
		List<CouncelingDTO> councelingDTO = counselingService.getCounselingByPharmacist(id);
		return councelingDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(councelingDTO);
	}

	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT')")
	@GetMapping(value = "/getUpcomingFreeCounselingByPharmacist/{id}")
	public ResponseEntity<List<CouncelingDTO>> getUpcomingCounselingsByPharmacist(@PathVariable Long id) 
	{
		List<CouncelingDTO> councelingDTO = counselingService.getUpcomingFreeCounselingByPharmacist(id);
		return councelingDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(councelingDTO);
	}

	@PreAuthorize("hasRole('PHARMACIST')")
	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> updateCounseling(@Valid @RequestBody Counseling counseling, BindingResult result) throws Exception
	{
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		CouncelingDTO e =counselingService.update(counseling);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PATIENT','PHARMACYADMIN')")
	@GetMapping(value = "/getFreeCounselingByPharmacist/{id}")
	public ResponseEntity<List<CouncelingDTO>> getFreeCounselingByPharmacist(@PathVariable Long id) 
	{
		List<CouncelingDTO> councelingDTOs = counselingService.getFreeCounselingByPharmacist(id);
		return councelingDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(councelingDTOs);
	}
}
