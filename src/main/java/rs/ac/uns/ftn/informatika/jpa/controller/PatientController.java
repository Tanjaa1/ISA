package rs.ac.uns.ftn.informatika.jpa.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rabbitmq.client.RpcClient.Response;

import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.service.PatientService;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
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
/*
	@PostMapping(value = "/update")
	public ResponseEntity<PatientDTO> updateGreeting(@RequestBody Patient patient) throws Exception {	
		//patientService.update(patient);
		PatientDTO p = new PatientDTO(patientService.update(patient));
		return p == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(p);
	}
*/

	@GetMapping(value = "/getPatientByDermatologistExamination/{id}")
	public ResponseEntity<List<PatientDTO>> getPatientByExamination(@PathVariable Long id) {
		List<PatientDTO> patients=patientService.findPatients(id);
		return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
	}
}
