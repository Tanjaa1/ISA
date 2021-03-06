package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;

@RestController
@RequestMapping(value = "/pharmacy")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PharmacyController {
    
    @Autowired
    private PharmacyService pharmacyService;
	
    
    @GetMapping(value = "/getAll")
	public ResponseEntity<List<PharmacyDTO>> getAllPharmacies() {
		List<PharmacyDTO> pharmaciesDTO = new ArrayList<PharmacyDTO>();
		List<Pharmacy> pharmacies = pharmacyService.findAll();
		for (Pharmacy pharmacy : pharmacies) {
			pharmaciesDTO.add(new PharmacyDTO(pharmacy));
		}
		return pharmaciesDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmaciesDTO);
	}
	
	@GetMapping(value = "/searchPharmacyByNameAndPlace/{name}/{place}")
	public ResponseEntity<List<PharmacyDTO>> getAllPharmaciesForSearch(@PathVariable String name,@PathVariable String place){
		List<PharmacyDTO> pharmaciesDTO = new ArrayList<PharmacyDTO>();
		List<Pharmacy> pharmacies = pharmacyService.findPharmacyByNameAndPlace(name, place);
		for (Pharmacy pharmacy : pharmacies) {
			pharmaciesDTO.add(new PharmacyDTO(pharmacy));
		}
		return pharmaciesDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmaciesDTO);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/savePharmacy")
	public ResponseEntity<Pharmacy> savePharmacy(@RequestBody Pharmacy pharmacyDTO) throws Exception{
		pharmacyService.save(pharmacyDTO);
	return new ResponseEntity<>(pharmacyDTO, HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PutMapping(value = "/update")
	public ResponseEntity<PharmacyDTO> update(@RequestBody Pharmacy pharmacy) throws Exception{
		pharmacyService.update(pharmacy);
	return new ResponseEntity<>(new PharmacyDTO(pharmacy), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPharmacies")
	public ResponseEntity<List<Pharmacy>> getAll() {
		List<Pharmacy> pharmacies =pharmacyService.getAll();
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}
	@GetMapping(value = "/getAllPharmacyNames")
	public ResponseEntity<List<String>> getAllPharmacyNames() {
		List<String> usernames =pharmacyService.getAllPharmacyNames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/isNameValid/{name}")
	public ResponseEntity<Boolean> isNameValid(@PathVariable String name) {
		Boolean isValid = pharmacyService.isNameValid(name);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@PreAuthorize("hasAnyRole('PHARMACYADMIN','PATIENT')")
	@GetMapping(value = "/getByName/{name}")
	public ResponseEntity<PharmacyDTO> getByName(@PathVariable String name) {
		PharmacyDTO pharmacy = new PharmacyDTO(pharmacyService.getByName(name));
		return pharmacy == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacy);
	}

	@GetMapping(value = "/getMedicineFromPharmacy/{name}")
	public ResponseEntity<List<PharmacyDTO>> getMedicineFromPharmacy(@PathVariable String name) {
		List<PharmacyDTO> pharmacies = pharmacyService.findPharmacyByMedicineName(name);
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}
	
	@PutMapping(value = "/updateQuantity/{id}")
	public ResponseEntity<HttpStatus> updateQuantity(@PathVariable Long id,@RequestBody Medicine medicine){
		pharmacyService.updateQuantity(id,medicine);
	return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPharmacies/{id}")
	public ResponseEntity<List<PharmacyDTO>> getPharmacies(@PathVariable Long id) {
		List<PharmacyDTO> pharmacies = pharmacyService.getPharmacies(id);
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}

	@PostMapping(value = "/giveMarkPharmacy/{medicinesMark}/{id}")
	public ResponseEntity<PharmacyDTO> addMark(@RequestBody Pharmacy pharmacy, @PathVariable Integer medicinesMark, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(pharmacyService.addMark(pharmacy,medicinesMark, id));
	}

	@GetMapping(value = "/getPharmaciesPriceLists")
	public ResponseEntity<List<MedicinePriceAndQuantityDTO>> getPharmaciesPriceLists() {
		List<MedicinePriceAndQuantityDTO> pharmacies = pharmacyService.getPharmaciesPriceLists();
		return pharmacies == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacies);
	}
	@GetMapping(value = "/getPharmacyByPriceListId/{id}")
	public ResponseEntity<PharmacyDTO> getPharmacyByPriceListId(@PathVariable Long id) {
		PharmacyDTO pharmacie = pharmacyService.getPharmacyByPriceListId(id);
		return pharmacie == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacie);
	}
	@GetMapping(value = "/findPharmacyBzListMedicines")
	public ResponseEntity<List<PharmacyDTO>> findPharmacyBzListMedicines(@RequestBody Map<String,Integer> map) {
		List<PharmacyDTO> pharmacie = pharmacyService.findPharmacyBzListMedicines(map);
		return pharmacie == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacie);
	}

	
	
	
	@PutMapping(value = "/subscribeUser/{pID}")
	public ResponseEntity<Boolean> update(@RequestBody PharmacyDTO pharmacy,@PathVariable Long pID) throws Exception{
		Boolean response = pharmacyService.subscribeUser(pharmacy,pID);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


}
