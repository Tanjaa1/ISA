package rs.ac.uns.ftn.informatika.jpa.controller;

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

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistService;

@RestController
@RequestMapping(value = "/pharmacist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PharmaciestController {
    @Autowired
	private PharmacistService pharmacistService;
	
	@GetMapping(value = "/getPharmacistById/{id}")
	public ResponseEntity<PharmacistDTO> getDermatologistById(@PathVariable Long id) {
		PharmacistDTO pharmacist = new PharmacistDTO(pharmacistService.findOne(id));
		return pharmacist == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacist);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<PharmacistDTO> updateGreeting(@RequestBody Pharmacist pharmacist) throws Exception {
		PharmacistDTO p = new PharmacistDTO(pharmacistService.update(pharmacist));
		return p == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(p);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<PharmacistDTO>> getAll() {
    List<PharmacistDTO> retVal = pharmacistService.findAll();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
  	}
	  
	  @PutMapping(value ="/confirmationEmailPharmacist/{Id}")
	  public ResponseEntity<Boolean> confirmationEmail(@PathVariable String Id) throws Exception {
		  Boolean success = pharmacistService.confirmationEmail(Long.parseLong(Id));
		  return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	  }

	  
	  @PostMapping(value = "/savePharmacist")
	  public ResponseEntity<Pharmacist> savePatient(@RequestBody Pharmacist patientDTO) throws Exception{
		pharmacistService.save(patientDTO);
	  return new ResponseEntity<>(patientDTO, HttpStatus.CREATED);
	  }

	  @GetMapping(value = "/isUsernameValid/{username}")
		public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = pharmacistService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

}
