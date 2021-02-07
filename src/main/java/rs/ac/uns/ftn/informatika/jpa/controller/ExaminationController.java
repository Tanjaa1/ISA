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

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
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
	public ResponseEntity<List<Examination>> getFutureExaminationByPatientId(@PathVariable Long id) 
	{
		List<ExaminationDTO> examinationDTOs = new ArrayList<ExaminationDTO>();
		List<Examination> examinations = examinationService.findFutureExaminationsByPatientId(id);
		for (Examination examination : examinations) {
			examinationDTOs.add(new ExaminationDTO(examination));
		}
		return examinations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinations);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody Examination examination) throws Exception
	{
		Examination e =examinationService.update(examination.getId());
		return e == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getExaminationById/{id}")
	public ResponseEntity<Examination> getExaminationById(@PathVariable Long id) 
	{
		Examination examination = examinationService.getExaminationById(id);
		return examination == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examination);
	}
}
