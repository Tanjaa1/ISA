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

import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;

@RestController
@RequestMapping(value = "/examination")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExaminationController {
    
    @Autowired
	private ExaminationService examinationService;
	
	@GetMapping(value = "/getPastExaminationByPatientId/{id}")
	public ResponseEntity<List<Examination>> getPastExaminationByPatientId(@PathVariable Long id) {
		List<Examination> examinations = examinationService.findPastExaminationsByPatientId(id);
		return examinations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinations);
	}

    @GetMapping(value = "/getFutureExaminationByPatientId/{id}")
	public ResponseEntity<List<Examination>> getFutureExaminationByPatientId(@PathVariable Long id) {
		List<Examination> examinations = examinationService.findFutureExaminationsByPatientId(id);
		return examinations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinations);
	}
}
