package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologist")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class DermatologistController {
    @Autowired
	private DermatologistService dermatologistService;
	
	@GetMapping(value = "/getDermatologistById/{id}")
	public ResponseEntity<DermatologistDTO> getDermatologistById(@PathVariable Long id) {
		DermatologistDTO dermatologist = new DermatologistDTO(dermatologistService.findOne(id));
		return dermatologist == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(dermatologist);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<DermatologistDTO> updateGreeting(@RequestBody Dermatologist dermatologist) throws Exception {
		DermatologistDTO d = new DermatologistDTO(dermatologistService.update(dermatologist));
		return d == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(d);    
	}
  @GetMapping(value = "/getAllDermatologists")
	public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {
    List<DermatologistDTO> retVal = dermatologistService.findAll();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
  }

}
