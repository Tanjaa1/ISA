package rs.ac.uns.ftn.informatika.jpa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

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
	public ResponseEntity<PharmacistDTO> updateGreeting(@Valid @RequestBody Pharmacist pharmacist, BindingResult result) throws Exception {
		
		if (result.hasErrors()) 
			return new ResponseEntity<>(new PharmacistDTO(),HttpStatus.BAD_REQUEST);
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
	  public ResponseEntity<Pharmacist> savePatient(@Valid @RequestBody Pharmacist pharmacist, BindingResult result) throws Exception{
		  
		if (result.hasErrors()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		pharmacistService.save(pharmacist);
	  return new ResponseEntity<>(pharmacist,HttpStatus.CREATED);
	  }

	  @GetMapping(value = "/isUsernameValid/{username}")
		public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = pharmacistService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@GetMapping(value = "/getPharmacies/{timeStart}")
	public ResponseEntity<List<PharmacyDTO>> getPharmaciesByAvailavblePharmaciest(@PathVariable String timeStart) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(timeStart, formatter);
		List<PharmacyDTO> pharmacyDTOs = pharmacistService.gPharmaciesByPharmaciest(dateTime);
		return pharmacyDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacyDTOs);
	}

	@GetMapping(value = "/getPharmacistByPharmacyId/{id}")
	public ResponseEntity<List<PharmacistDTO>> getPharmaciesByAvailavblePharmaciest(@PathVariable Long id) {
		List<PharmacistDTO> pharmacistDTOs = pharmacistService.getPharmacistByPharmacyId(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}
	
	@GetMapping(value = "/getPharmacistByPatientId/{id}")
	public ResponseEntity<List<PharmacistDTO>> getPharmacistByPatientId(@PathVariable Long id) {
		List<PharmacistDTO> pharmacistDTOs = pharmacistService.getPharmacists(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@PostMapping(value = "/giveMarkPharmacist/{medicinesMark}/{id}")
	public ResponseEntity<PharmacistDTO> addMark(@RequestBody Pharmacist pharmacist, @PathVariable Integer medicinesMark, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(pharmacistService.addMark(pharmacist,medicinesMark, id));
	}
	@PreAuthorize("hasRole('PHARMACIST')")
	@GetMapping(value = "/getPharmacistByCredentials/{username}")
	public ResponseEntity<PharmacistDTO> getPharmacistByCredentials(@PathVariable String username) {
		PharmacistDTO patient = new PharmacistDTO(pharmacistService.getPharmacistByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}


	@GetMapping(value = "/getByPharmacyId/{id}")
	public ResponseEntity<List<PharmacistDTO>> getByPharmacyId(@PathVariable Long id) {
		List<PharmacistDTO> pharmacistDTOs = pharmacistService.getPharmacistByPharmacyId(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}	

	@PostMapping(value = "/addNewPharmacistToPharmacy")
	public ResponseEntity<Pharmacist> checkUserAndEmail( @RequestBody Pharmacist pharmacist) throws Exception {
		return ResponseEntity.ok(pharmacistService.addNewPharmacistToPharmacy(pharmacist));
	}
	
	@PutMapping(value = "/addExistingPharmacistToPharmacy/{pharmacistUsername}/{pharmacyUsername}")
	public ResponseEntity<Boolean> addExistingDermatologistToPharmacy( @PathVariable Long pharmacistUsername,@PathVariable Long pharmacyUsername,@Valid @RequestBody Pharmacist dermatologist) throws Exception {
		return ResponseEntity.ok(pharmacistService.addExistingPharmacistToPharmacy(pharmacistUsername,pharmacyUsername));
	}

	@GetMapping(value = "/checkUserAndEmail/{username}/{email}")
	public ResponseEntity<String> checkUserAndEmail(@PathVariable String username,@PathVariable String email) throws Exception {
		return ResponseEntity.ok(pharmacistService.checkUserAndEmail(username,email));
	}

	@GetMapping(value = "/getUnemployedPharmacists/{id}")
	public ResponseEntity<List<PharmacistDTO>> getUnemployedDermatolgoists(@PathVariable Long id) {
		List<PharmacistDTO> pharmacistDTOs = pharmacistService.getUnemployedPharmacists(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@PutMapping(value = "/addWorktimeToPharmacist/{id}")
	public ResponseEntity<Boolean> addWorktimeToPharmacist(@PathVariable Long id, @Valid @RequestBody WorkingTime WT) throws Exception {
		return ResponseEntity.ok(pharmacistService.addWorktimeToPharmacist(id,WT));
	}

	@PutMapping(value = "/removeFromPharmacy/{id}")
	public ResponseEntity<Boolean> addWorktimeToPharmacist(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(pharmacistService.removeFromPharmacy(id));
	}
}
