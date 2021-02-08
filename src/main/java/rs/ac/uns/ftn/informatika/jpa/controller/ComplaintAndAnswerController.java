package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintAnswerService;

@RestController
@RequestMapping(value = "/complaintAndAnswer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComplaintAndAnswerController {
    @Autowired
	private ComplaintAnswerService complaintAndAnswerService;
	
	

	@PostMapping(value = "/saveComplaintAndAnswer")
	public ResponseEntity<ComplaintAnswer> saveComplaintAndAnswer(@RequestBody ComplaintAnswer complaintDTOAnswer) throws Exception {
		complaintAndAnswerService.save(complaintDTOAnswer);
	return new ResponseEntity<>(complaintDTOAnswer, HttpStatus.CREATED);
	}
}
