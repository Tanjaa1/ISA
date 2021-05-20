package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyAdminService;

@RestController
@RequestMapping(value = "/pharmacyAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PharmacyAdminController {
    @Autowired
    private PharmacyAdminService pharmacyAdminService;
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/savePharmacyAdmin")
	public ResponseEntity<PharmacyAdmin> savePatient(@RequestBody PharmacyAdmin pharmacyAdminDTO) throws Exception{
		pharmacyAdminService.save(pharmacyAdminDTO);
	return new ResponseEntity<>(pharmacyAdminDTO, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPharmacyAdinUsernames")
	public ResponseEntity<List<String>> getAllPharmacyAdinUsernames() {
		List<String> usernames =pharmacyAdminService.getAllSystemAdminUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = pharmacyAdminService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
	
	@PostMapping(value = "/sendingMail/{pharmacyName}")
	public ResponseEntity<HttpStatus> sendingMail(@PathVariable String pharmacyName,@RequestBody Medicine medicine) {
		Boolean sent =pharmacyAdminService.sendingMail(pharmacyName,medicine);
		return sent == false ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value ="/confirmationEmailPharmacyAdmin/{Id}")
	public ResponseEntity<Boolean> confirmationEmail(@PathVariable String Id) throws Exception {
		Boolean success = pharmacyAdminService.confirmationEmail(Long.parseLong(Id));
		return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	}
	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/getPharmacyAdminByCredentials/{username}")
	public ResponseEntity<PharmacyAdminDTO> getPharmacyAdminByCredentials(@PathVariable String username) {
		PharmacyAdminDTO patient = new PharmacyAdminDTO(pharmacyAdminService.getPharmacyAdminByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}
}
