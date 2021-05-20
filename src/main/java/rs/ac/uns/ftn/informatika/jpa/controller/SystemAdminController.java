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

import rs.ac.uns.ftn.informatika.jpa.dto.SystemAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;
import rs.ac.uns.ftn.informatika.jpa.service.SystemAdminService;

@RestController
@RequestMapping(value = "/systemAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;
    
    @PostMapping(value = "/saveSystemAdmin")
	public ResponseEntity<SystemAdmin> savePatient(@RequestBody SystemAdmin systemaAdminDTO) throws Exception{
		systemAdminService.save(systemaAdminDTO);
	return new ResponseEntity<>(systemaAdminDTO, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSystemAdinUsernames")
	public ResponseEntity<List<String>> getAllSystemAdinUsernames() {
		List<String> usernames =systemAdminService.getAllSystemAdinUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}

	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = systemAdminService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@PutMapping(value ="/confirmationEmailSystemAdmin/{patientId}")
	public ResponseEntity<Boolean> confirmationEmail(@PathVariable String patientId) throws Exception {
		Boolean success = systemAdminService.confirmationEmail(Long.parseLong(patientId));
		return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getSystemAdminByCredentials/{username}")
	public ResponseEntity<SystemAdminDTO> getPatientByCredentials(@PathVariable String username) {
		SystemAdminDTO patient = new SystemAdminDTO(systemAdminService.getSystemAdminByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}
}
