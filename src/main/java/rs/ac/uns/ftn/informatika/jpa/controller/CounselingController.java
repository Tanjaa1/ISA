package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

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

	@PutMapping(value = "/update")
	public ResponseEntity<Counseling> update(@RequestBody Counseling counseling) throws Exception
	{
		Counseling e =counselingService.update(counseling.getId());
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(e);
	}

}
