package rs.ac.uns.ftn.informatika.jpa.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.service.EPrescriptionService;

@RestController
@RequestMapping(value = "/eprescription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EPrescritpionController {

    @Autowired
	private EPrescriptionService ePrescriptionService;


	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	@PostMapping(value = "/add/{id}")
	public ResponseEntity<EPrescriptionDTO> addEPrescritpion(@Valid @RequestBody EPrescription ePrescriptionDTO, BindingResult result,@PathVariable Long id) throws Exception {
		if (result.hasErrors()) 
			return new ResponseEntity<>(new EPrescriptionDTO(), HttpStatus.BAD_REQUEST);
		EPrescription ep= ePrescriptionService.save(ePrescriptionDTO,id);
		return ep == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);  
	}

	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
    @GetMapping(value = "/findMedicines/{id}")
	public ResponseEntity<List<MedicinePriceAndQuantityDTO>> findMedicineByPharmacy(@PathVariable Long id) {
		List<MedicinePriceAndQuantityDTO> medicines=ePrescriptionService.findMedicineByPharmacy(id);
		return medicines == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicines);  
	}
}
