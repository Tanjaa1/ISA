package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.LoyaltyProgrammeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.service.LoyaltyProgrammeService;

@RestController
@RequestMapping(value = "/loyaltyProgramme")
public class LoyaltyProgrammeController {
    @Autowired
	private LoyaltyProgrammeService loyaltyProgrammeService;

    @GetMapping(value = "/addLP/")
	public ResponseEntity<LoyaltyProgramme> saveLP(@RequestBody LoyaltyProgrammeDTO loyaltyProgrammeDTO) throws Exception{
		loyaltyProgrammeService.save(new LoyaltyProgramme(loyaltyProgrammeDTO));
	return new ResponseEntity<>(new LoyaltyProgramme(loyaltyProgrammeDTO), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/updateLP")
	public ResponseEntity<LoyaltyProgramme> updateLP(@RequestBody LoyaltyProgrammeDTO lpDTO) throws Exception{
		loyaltyProgrammeService.update(new LoyaltyProgramme(lpDTO));
	return new ResponseEntity<>(new LoyaltyProgramme(lpDTO), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getLP/")
	public ResponseEntity<LoyaltyProgramme> getLP() throws Exception{
		LoyaltyProgrammeDTO lp=loyaltyProgrammeService.getLP();
	return new ResponseEntity<>(new LoyaltyProgramme(lp), HttpStatus.CREATED);
	}
    
}
