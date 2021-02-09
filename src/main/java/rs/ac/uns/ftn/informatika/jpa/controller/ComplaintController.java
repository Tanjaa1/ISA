package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

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

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintService;

@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComplaintController {

    @Autowired
	private ComplaintService complaintService;
	
	

	@PostMapping(value = "/saveComplaint")
	public ComplaintDTO saveComplaint(@RequestBody Complaint complaintDTO) throws Exception {
		ComplaintDTO complaint=complaintService.save(complaintDTO);
	return complaint;
	}

	@PutMapping(value = "/updateComplaint")
	public ResponseEntity<Complaint> updateComplaint(@RequestBody Complaint complaintDTO) throws Exception {
		complaintService.save(complaintDTO);
	return new ResponseEntity<>(complaintDTO, HttpStatus.CREATED);
	}
    

	@GetMapping(value = "/getAllComplaintsAnswered")
	public List<ComplaintDTO> getAllComplaintsAnswered() {
		List<ComplaintDTO> codes =complaintService.getAllComplaintsAnswered();
		return codes;
	}
	@GetMapping(value = "/getAllComplaints")
	public List<ComplaintDTO> getAllComplaints() {
		List<ComplaintDTO> codes =complaintService.getAllComplaints();
		return codes;
	}

	@GetMapping(value = "/getAllComplaintsNotAnswered")
	public List<ComplaintDTO> getAllComplaintsNotAnswered() {
		List<ComplaintDTO> codes =complaintService.getAllComplaintsNotAnswered();
		return codes;
	}

	
	@GetMapping(value = "/getById/{id}")
	public ComplaintDTO getById(@PathVariable Long id) {
		ComplaintDTO complaintDTO =complaintService.getById(id);
		return complaintDTO;
	}

	@GetMapping(value = "/getAllSubjects/{id}")
	public Set<String> getAllSubjects(@PathVariable Long id) {
		Set<String> subjects =complaintService.getAllSubjects(id);
		return subjects;
	}

}
