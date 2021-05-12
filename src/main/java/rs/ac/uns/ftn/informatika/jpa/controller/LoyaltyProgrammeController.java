package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.LoyaltyProgrammeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.service.LoyaltyProgrammeService;

@RestController
@RequestMapping(value = "/loyaltyProgramme")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoyaltyProgrammeController {
    @Autowired
	private LoyaltyProgrammeService loyaltyProgrammeService;

    @GetMapping(value = "/addLP/")
	public ResponseEntity<LoyaltyProgramme> saveLP(@RequestBody LoyaltyProgrammeDTO loyaltyProgrammeDTO) throws Exception{
		loyaltyProgrammeService.save(new LoyaltyProgramme(loyaltyProgrammeDTO));
	return new ResponseEntity<>(new LoyaltyProgramme(loyaltyProgrammeDTO), HttpStatus.CREATED);
	}

    @GetMapping(value = "/updateLP/")
	public ResponseEntity<LoyaltyProgramme> updateLP(@RequestBody LoyaltyProgrammeDTO loyaltyProgrammeDTO) throws Exception{
		loyaltyProgrammeService.update(new LoyaltyProgramme(loyaltyProgrammeDTO));
	return new ResponseEntity<>(new LoyaltyProgramme(loyaltyProgrammeDTO), HttpStatus.CREATED);
	}
    
}
