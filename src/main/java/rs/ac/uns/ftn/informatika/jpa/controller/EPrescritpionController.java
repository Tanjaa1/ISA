package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.Set;

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

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.service.EPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistService;

@RestController
@RequestMapping(value = "/eprescription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EPrescritpionController {

    @Autowired
	private EPrescriptionService ePrescriptionService;


	@PostMapping(value = "/add/{id}")
	public ResponseEntity<EPrescriptionDTO> addEPrescritpion(@RequestBody EPrescriptionDTO ePrescriptionDTO,@PathVariable Long id) throws Exception {
		EPrescription ep= ePrescriptionService.save(ePrescriptionDTO,id);
		return ep == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);  
	}

    @GetMapping(value = "/findMedicines/{id}")
	public ResponseEntity<Set<MedicinePriceAndQuantity>> findMedicineByPharmacy(@PathVariable Long id) {
		Set<MedicinePriceAndQuantity> medicines=ePrescriptionService.findMedicineByPharmacy(id);
		return medicines == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicines);  
	}
}
