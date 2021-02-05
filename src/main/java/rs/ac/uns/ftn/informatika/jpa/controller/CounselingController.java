package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.service.CounselingService;

@RestController
@RequestMapping(value = "/counseling")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CounselingController {
 
    @Autowired
	private CounselingService counselingService;
	
	@GetMapping(value = "/getPastCounselingByPatientId/{id}")
	public ResponseEntity<List<Counseling>> getPastCounselingByPatientId(@PathVariable Long id) {
		List<Counseling> counselings = counselingService.findPastCounselingsByPatientId(id);
		return counselings == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(counselings);
	}

    @GetMapping(value = "/getFutureCounselingByPatientId/{id}")
	public ResponseEntity<List<Counseling>> getFutureCounselingByPatientId(@PathVariable Long id) {
		List<Counseling> counselings = counselingService.findFutureCounselingsByPatientId(id);
		return counselings == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(counselings);
	}
}
