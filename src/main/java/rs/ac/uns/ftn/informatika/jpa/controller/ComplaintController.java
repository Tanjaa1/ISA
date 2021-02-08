package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintService;

@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComplaintController {

    @Autowired
	private ComplaintService complaintService;
	
	

	@PostMapping(value = "/saveComplaint")
	public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint complaintDTO) throws Exception {
		complaintService.save(complaintDTO);
	return new ResponseEntity<>(complaintDTO, HttpStatus.CREATED);
	}
    
}
