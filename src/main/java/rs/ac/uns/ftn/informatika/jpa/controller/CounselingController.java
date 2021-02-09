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
		List<Counseling> counselings = counselingService.findFutureCounselingsByPatientId(id);
		for (Counseling counseling : counselings) {
			counselingsDTO.add(new CouncelingDTO(counseling));
		}
		return counselingsDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(counselingsDTO);
	}

	@PutMapping(value = "/finish")
	public ResponseEntity<HttpStatus> update(@RequestBody Counseling counseling) throws Exception
	{
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
	public ResponseEntity<HttpStatus> cancelCounseling(@RequestBody Counseling counseling) throws Exception
	{
		Counseling e =counselingService.updateCounseling(counseling);
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping(value = "/add")
	public ResponseEntity<CouncelingDTO> newExamination(@RequestBody Counseling counseling)
		throws Exception 
	{
		return ResponseEntity.ok(counselingService.newExamination(counseling));
	}

}
