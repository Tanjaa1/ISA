package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;

@RestController
@RequestMapping(value = "/pharmacy")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PharmacyController {
    
    @Autowired
    private PharmacyService pharmacyService;
    
    @GetMapping(value = "/getAll")
	public ResponseEntity<List<Pharmacy>> getAllPharmacies() {
		List<Pharmacy> pharmacies = pharmacyService.findAll();
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}
}
