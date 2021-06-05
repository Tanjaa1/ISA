package rs.ac.uns.ftn.informatika.jpa.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;

import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    
	@Autowired
	private UserService userService;

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping("/user/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}

	@GetMapping("/whoami")
	@PreAuthorize("hasRole('USER')")
	public User user(Principal user) {
		return this.userService.findByUsername(user.getName());
	}
	
	@GetMapping("/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }

	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT','SUPPLIER','DERMATOLOGIST','ADMIN')")
	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = userService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
	@PostMapping(value = "/saveUser")
	public ResponseEntity<User> saveUserByPatient(@RequestBody Patient user) throws Exception{
		userService.saveUserByPatient(user);
	return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@PostMapping(value = "/saveUserBySupplier")
	public ResponseEntity<User> saveUserBySupplier(@RequestBody Supplier user) throws Exception{
		userService.saveUserBySupplier(user);
	return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@PutMapping(value = "/updateUserBySupplier")
	public void updateUserBySupplier(@RequestBody SupplierDTO user) throws Exception{
		userService.updateUserBySupplier(user);
	}
	@PostMapping(value = "/saveUserBySystemAdmin")
	public ResponseEntity<User> saveUserBySystemAdmin(@RequestBody SystemAdmin user) throws Exception{
		userService.saveUserBySystemAdmin(user);
	return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/updateUserBySystemAdmin")
	public void updateUserBySystemAdmin(@RequestBody SystemAdmin user) throws Exception{
		userService.updateUserBySystemAdmin(user);
	}
	@PostMapping(value = "/saveUserByPharmacyAdmin")
	public ResponseEntity<User> saveUserByPharmacyAdmin(@RequestBody PharmacyAdminDTO user) throws Exception{
		userService.saveUserByPharmacyAdmin(user);
	return new ResponseEntity<>(new PharmacyAdmin(user), HttpStatus.CREATED);
	}
	@PutMapping(value = "/updateUserByPharmacyAdmin")
	public ResponseEntity<User> updateUserByPharmacyAdmin(@RequestBody PharmacyAdminDTO user) throws Exception{
		userService.updateUserByPharmacyAdmin(user);
	return new ResponseEntity<>(new PharmacyAdmin(user), HttpStatus.CREATED);
	}
	@PostMapping(value = "/saveUserByPharmacist")
	public ResponseEntity<User> saveUserByPharmacist(@RequestBody Pharmacist user) throws Exception{
		userService.saveUserByPharmacist(user);
	return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@PostMapping(value = "/saveUserByDermatologist")
	public ResponseEntity<User> saveUserByDermatologist(@RequestBody Dermatologist user) throws Exception{
		userService.saveUserByDermatologist(user);
	return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT','SUPPLIER','DERMATOLOGIST','ADMIN')")
	@GetMapping(value = "/getByUsername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		User isValid = userService.getByUsername(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
}
