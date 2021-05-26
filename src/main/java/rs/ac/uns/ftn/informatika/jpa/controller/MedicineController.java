package rs.ac.uns.ftn.informatika.jpa.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.google.zxing.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineForSearch;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineSDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyQRDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;

@RestController
@RequestMapping(value = "/medicine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/saveMedicine")
	public ResponseEntity<Medicine> saveMedicine(@RequestBody MedicineSDTO medicineDTO) throws Exception{
		medicineService.save(new Medicine(medicineDTO));
	return new ResponseEntity<>(new Medicine(medicineDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCodes")
	public ResponseEntity<List<String>> getAllCodes() {
		List<String> codes =medicineService.getAllCodes();
		return codes == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(codes);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/isCodeValid/{code}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String code) {
		Boolean isValid = medicineService.isUsernameValid(code);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<MedicineDTO>> getAll() {
    List<MedicineDTO> retVal = medicineService.findAll();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
  	}
	@PostMapping(value = "/saveMedicinePriceAndQuantity")
	public ResponseEntity<MedicinePriceAndQuantity> saveMedicinePriceAndQuantity(@RequestBody MedicinePriceAndQuantityDTO medicineDTO) throws Exception{
		return null;
	}

	@PutMapping(value = "/saveMedicinePriceAndQuantity")
	public ResponseEntity<MedicinePriceAndQuantity> updatePriceAndQuantity(@RequestBody MedicinePriceAndQuantityDTO medicineDTO) throws Exception{
		return null;
	}

	@GetMapping(value = "/findMedicine/{name}")
	public ResponseEntity<MedicineDTO> findMedicine(@PathVariable String name) {
		MedicineDTO medicineDTO= medicineService.findMedicine(name);
		return medicineDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTO);
	}
	
	@GetMapping(value = "/getMedicineByPatientId/{id}")
	public ResponseEntity<List<MedicineDTO>> getMedicineByPatientId(@PathVariable Long id) {
		List<MedicineDTO> medicineDTOs = medicineService.getMedicinesAll(id);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@PostMapping(value = "/giveMarkMedicine/{medicinesMark}/{id}")
	public ResponseEntity<MedicineDTO> addMark(@RequestBody Medicine medicine, @PathVariable Integer medicinesMark, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(medicineService.addMark(medicine,medicinesMark, id));
	}

	@GetMapping(value = "/getPharmacyForAvaliableMedicine/{medicineName}")
	public ResponseEntity<List<MedicineForSearch>> getMedicineByPatientId(@PathVariable String medicineName) {
		List<MedicineForSearch> medicineDTOs = medicineService.getPharmacyForAvaliableMedicine(medicineName);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/getPharmacyForAvaliableMedicineAndQuantity/{medicineName}/{quantity}")
	public ResponseEntity<List<MedicineForSearch>> getPharmacyForAvaliableMedicineAndQuantity(@PathVariable String medicineName,@PathVariable Integer quantity) {
		List<MedicineForSearch> medicineDTOs = medicineService.getPharmacyForAvaliableMedicineAndQuantity(medicineName,quantity);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/combinedSearch/{parameters}")
	public ResponseEntity<Set<MedicineForSearch>> combinedSearch(@PathVariable String parameters) {
		Set<MedicineForSearch> medicineDTOs = medicineService.combinedSearch(parameters);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/filtrationMedicineByType/{medicineName}/{type}")
	public ResponseEntity<List<MedicineForSearch>> filtrationMedicineByType(@PathVariable String medicineName,@PathVariable String type) {
		List<MedicineForSearch> medicineDTOs = medicineService.filtrationMedicineByType(medicineName,type);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/filtrationMedicineByForm/{medicineName}/{form}")
	public ResponseEntity<List<MedicineForSearch>> filtrationMedicineByForm(@PathVariable String medicineName,@PathVariable String form) {
		List<MedicineForSearch> medicineDTOs = medicineService.filtrationMedicineByForm(medicineName,form);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/filtrationMedicineByMark/{medicineName}/{mark}")
	public ResponseEntity<List<MedicineForSearch>> filtrationMedicineByMark(@PathVariable String medicineName,@PathVariable String mark) {
		List<MedicineForSearch> medicineDTOs = medicineService.filtrationMedicineByMark(medicineName,mark);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/filtrationMedicineOnPrescription/{medicineName}")
	public ResponseEntity<List<MedicineForSearch>> filtrationMedicineOnPrrescription(@PathVariable String medicineName) {
		List<MedicineForSearch> medicineDTOs = medicineService.filtrationMedicineOnPrescription(medicineName);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/filtrationMedicineNotOnPrescription/{medicineName}")
	public ResponseEntity<List<MedicineForSearch>> filtrationMedicineNotOnPrescription(@PathVariable String medicineName) {
		List<MedicineForSearch> medicineDTOs = medicineService.filtrationMedicineNotOnPrescription(medicineName);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}

	@GetMapping(value = "/uploadQR")
	public ResponseEntity<String> uploadQR(@RequestBody String path) throws FileNotFoundException, NotFoundException, IOException {
		String medicineDTOs = medicineService.uploadQR(path);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}


	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/getPharmaciesByQR/{patientId}")
	public ResponseEntity<Set<PharmacyQRDTO>> getPharmaciesByQR(@RequestParam String par,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		Set<PharmacyQRDTO> medicineDTOs = medicineService.getPharmaciesByQR(par,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyGradeQRASC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyGradeQR(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyGradeQR(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyGradeQRDESC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyGradeQRDESC(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyGradeQRDESC(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}	
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyPriceQRACS/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyPriceQR(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyPriceQR(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyPriceQRDESC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyPriceQRDESC(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyPriceQRDESC(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyNameQRASC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyNameQR(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyNameQR(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyNameDESC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyNameDESC(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyNameDESC(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyAddressQRASC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyAddressQR(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyAddressQR(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping(value = "/sortByPharmacyAddressQRDESC/{patientId}")
	public ResponseEntity<List<PharmacyQRDTO>> sortByPharmacyAddressQRDESC(@RequestParam String path,@PathVariable Long patientId) throws FileNotFoundException, NotFoundException, IOException  {
		List<PharmacyQRDTO> medicineDTOs = medicineService.sortByPharmacyAddressQRDESC(path,patientId);
		return medicineDTOs == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(medicineDTOs);
	}
	
	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@GetMapping(value = "/getAllAR")
	public ResponseEntity<List<MedicineDTO>> getAllAR() {
	List<MedicineDTO> retVal = medicineService.getAllAR();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@DeleteMapping(value = "/deleteFromPricelist/{Id}/{pharmacyID}")
	  public boolean deleteFromPricelist(@PathVariable Long Id,@PathVariable Long pharmacyID) throws Exception{
		  return medicineService.deleteMedicineFromPricelist(Id,pharmacyID);
	}

	@PostMapping(value = "/addToPricelist/{Pharmacy}")
	public ResponseEntity<MedicinePriceAndQuantity> addToPricelist(@RequestBody MedicinePriceAndQuantity medicineDTO,@PathVariable Long Pharmacy) throws Exception{
		return  medicineService.addToPricelist(medicineDTO,Pharmacy);

	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PostMapping(value = "/addMedicinePriceAndQuantity")
	public ResponseEntity<MedicinePriceAndQuantity> addMedicinePriceAndQuantity(@RequestBody MedicinePriceAndQuantity medicineDTO) throws Exception{
		return  medicineService.savePriceAndQuantity(medicineDTO);

	}

}

