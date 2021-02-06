package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;

@RestController
@RequestMapping(value = "/medicine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	@PostMapping(value = "/saveMedicine")
	public ResponseEntity<Medicine> saveMedicine(@RequestBody MedicineDTO medicineDTO) throws Exception{
		medicineService.save(new Medicine(medicineDTO));
	return new ResponseEntity<>(new Medicine(medicineDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCodes")
	public ResponseEntity<List<String>> getAllCodes() {
		List<String> codes =medicineService.getAllCodes();
		return codes == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(codes);
	}

	@GetMapping(value = "/isCodeValid/{code}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String code) {
		Boolean isValid = medicineService.isUsernameValid(code);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}
}

