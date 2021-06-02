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
import rs.ac.uns.ftn.informatika.jpa.util.MedicineGraphInfo;
import rs.ac.uns.ftn.informatika.jpa.util.MapLocation;


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

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PutMapping(value = "/updateAdmin")
	public ResponseEntity<String> updateAdmin(@RequestBody PharmacyAdminDTO pharmacyAdminDTO) throws Exception{
	return new ResponseEntity<>(pharmacyAdminService.updateAdmin(pharmacyAdminDTO), HttpStatus.CREATED);
	}


	@GetMapping(value = "/getAllPharmacyAdinUsernames")
	public ResponseEntity<List<String>> getAllPharmacyAdinUsernames() {
		List<String> usernames =pharmacyAdminService.getAllSystemAdminUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}

	@PreAuthorize("hasAnyRole('ADMIN','PHARMACYADMIN')")
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<PharmacyAdminDTO> getPatientById(@PathVariable Long id) {
		PharmacyAdminDTO pharmacyAdmin = new PharmacyAdminDTO(pharmacyAdminService.findOne(id));
		return pharmacyAdmin == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacyAdmin);
	}

	@GetMapping(value = "/getById1/{id}")
	public ResponseEntity<PharmacyAdminDTO> getPatientById1(@PathVariable Long id) {
		PharmacyAdminDTO pharmacyAdmin = new PharmacyAdminDTO(pharmacyAdminService.findOne(id));
		return pharmacyAdmin == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacyAdmin);
	}

	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = pharmacyAdminService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
	
	@PreAuthorize("hasRole('DERMATOLOGIST')")
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

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/RevenueDaily/{pharmacyID}/{month}/{year}")
	public ResponseEntity<List<MedicineGraphInfo>> medicineConsumptionMonthly(@PathVariable Long pharmacyID,@PathVariable int month,@PathVariable int year) throws Exception {
	List<MedicineGraphInfo> retVal = pharmacyAdminService.revenueDaily(pharmacyID,month,year);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT')")
	@GetMapping(value = "/MapLocation/{Id}")
	public ResponseEntity<MapLocation> MapLocation(@PathVariable Long Id) {
		MapLocation retVal = pharmacyAdminService.getMapLocation(Id);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}
}
