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
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DermatologistController{
	
	@Autowired
	private DermatologistService dermatologistService;
	
	@GetMapping(value = "/getAllDermatologists")
	public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {
        List<DermatologistDTO> retVal = dermatologistService.findAll();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

}
