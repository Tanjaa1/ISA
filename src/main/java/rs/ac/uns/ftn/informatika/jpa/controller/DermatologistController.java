package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@RestController
@RequestMapping(value = "/dermatologist")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class DermatologistController {
    @Autowired
	private DermatologistService dermatologistService;
	
	@Autowired
	private PharmacyService pharmacyService;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/saveDermatologist/{idDe}")
	public ResponseEntity<Dermatologist> savePatient(@Valid @RequestBody Dermatologist dermatologistDTO,@PathVariable Long idDe, BindingResult result) throws Exception {
		if (result.hasErrors()) 
			new ResponseEntity<>(new DermatologistDTO(), HttpStatus.BAD_REQUEST);

		PharmacyDTO pharmacys = getFarmacyById(idDe);
		Set<Pharmacy> setPhyrmacies=new HashSet<Pharmacy>();
		setPhyrmacies.add(new Pharmacy(pharmacys));
		dermatologistDTO.setPharmacies(setPhyrmacies);
		dermatologistDTO.setLastPasswordResetDate(new Date());
		dermatologistService.save(dermatologistDTO);
	return new ResponseEntity<>(dermatologistDTO, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getFarmacyById/{id}")
	public PharmacyDTO getFarmacyById(@PathVariable Long id) {
		PharmacyDTO pharmacyDTO = new PharmacyDTO(pharmacyService.findOne(id));
		return pharmacyDTO ;
	}

	@GetMapping(value = "/getAllDermatologistUsernames")
	public ResponseEntity<List<String>> getAllDermatologistUsernames() {
		List<String> usernames =dermatologistService.getAllDermatologistUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = dermatologistService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
	
	@GetMapping(value = "/getDermatologistById/{id}")
	public ResponseEntity<DermatologistDTO> getDermatologistById(@PathVariable Long id) {
		DermatologistDTO dermatologist = new DermatologistDTO(dermatologistService.findOne(id));
		return dermatologist == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(dermatologist);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<DermatologistDTO> updateGreeting(@Valid @RequestBody Dermatologist dermatologist, BindingResult result) throws Exception {
		if (result.hasErrors()) 
			return new ResponseEntity<>(new DermatologistDTO(), HttpStatus.BAD_REQUEST);

		DermatologistDTO d = new DermatologistDTO(dermatologistService.update(dermatologist));
		return d == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(d);    
	}
	@GetMapping(value = "/getAllDermatologists")
		public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {
		List<DermatologistDTO> retVal = dermatologistService.findAll();
			return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}
	@PutMapping(value ="/confirmationEmailDermatologist/{dermaId}")
	public ResponseEntity<Boolean> confirmationEmail(@PathVariable String dermaId) throws Exception {
		Boolean success = dermatologistService.confirmationEmail(Long.parseLong(dermaId));
		return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	}

	@GetMapping(value = "/getDermatologistsByPatientId/{id}")
	public ResponseEntity<List<DermatologistDTO>> getPharmacistByPatientId(@PathVariable Long id) {
		List<DermatologistDTO> pharmacistDTOs = dermatologistService.getDermatologist(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@PostMapping(value = "/giveMarkDermatologist/{medicinesMark}/{id}")
	public ResponseEntity<DermatologistDTO> addMark(@RequestBody Dermatologist pharmacist, @PathVariable Integer medicinesMark, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(dermatologistService.addMark(pharmacist,medicinesMark, id));
	}
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	@GetMapping(value = "/getDermatologistByCredentials/{username}")
	public ResponseEntity<DermatologistDTO> getDermatologistByCredentials(@PathVariable String username) {
		DermatologistDTO patient = new DermatologistDTO(dermatologistService.getDermatologistByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}

	@GetMapping(value = "/getByPharmacyId/{id}")
	public ResponseEntity<List<DermatologistDTO>> getByPharmacyId(@PathVariable Long id) {
		List<DermatologistDTO> pharmacistDTOs = dermatologistService.getByPharmacyId(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@GetMapping(value = "/getUnemployedDermatolgoists/{id}")
	public ResponseEntity<List<DermatologistDTO>> getUnemployedDermatolgoists(@PathVariable Long id) {
		List<DermatologistDTO> pharmacistDTOs = dermatologistService.getUnemployedDermatolgoists(id);
		return pharmacistDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTOs);
	}

	@PostMapping(value = "/addNewDermatologistToPharmacy")
	public ResponseEntity<Dermatologist> checkUserAndEmail( @RequestBody Dermatologist dermatologist) throws Exception {
		return ResponseEntity.ok(dermatologistService.addNewDermatologistToPharmacy(dermatologist));
	}

	@PutMapping(value = "/addExistingDermatologistToPharmacy/{dermatologistUsername}/{pharmacyUsername}")
	public ResponseEntity<Boolean> addExistingDermatologistToPharmacy( @PathVariable Long dermatologistUsername,@PathVariable Long pharmacyUsername,@Valid @RequestBody Dermatologist dermatologist) throws Exception {
		return ResponseEntity.ok(dermatologistService.addExistingDermatologistToPharmacy(dermatologistUsername,pharmacyUsername));
	}

	@GetMapping(value = "/checkUserAndEmail/{username}/{email}")
	public ResponseEntity<String> checkUserAndEmail(@PathVariable String username,@PathVariable String email) throws Exception {
		return ResponseEntity.ok(dermatologistService.checkUserAndEmail(username,email));
	}

	@PutMapping(value = "/addWorktimeToDermatologist/{id}")
	public ResponseEntity<Boolean> addWorktimeToDermatologist(@PathVariable Long id, @Valid @RequestBody WorkingTime WT) throws Exception {
		return ResponseEntity.ok(dermatologistService.addWorktimeToDermatologist(id,WT));
	}
	
	@PutMapping(value = "/removeDermatologistFromPharmacy/{did}/{pid}")
	public ResponseEntity<Boolean> removeDermatologistFromPharmacy(@PathVariable Long did,@PathVariable Long pid) throws Exception {
		return ResponseEntity.ok(dermatologistService.removeFromPharmacy(did,pid));
	}

}
