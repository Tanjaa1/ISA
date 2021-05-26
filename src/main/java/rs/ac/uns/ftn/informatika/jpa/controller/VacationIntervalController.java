package rs.ac.uns.ftn.informatika.jpa.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.VacationIntervalDTO;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IVacationIntervalService;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

@RestController
@RequestMapping(value = "/vacation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VacationIntervalController {
      
	@Autowired
	private IVacationIntervalService vacationIntervalService;

	@PreAuthorize("hasRole('DERMATOLOGIST')")
    @PostMapping(value = "/addDermatologistVacation/{dermatologistId}")
	public ResponseEntity<HttpStatus> addDermatologistVacation(@RequestBody VacationInterval vacationInterval,@PathVariable Long dermatologistId)
		throws Exception 
	{
		VacationInterval v =vacationIntervalService.addDermatologististVacation(vacationInterval,dermatologistId);
		return v == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('PHARMACIST')")
    @PostMapping(value = "/addPharmacistVacation/{pharmacistId}")
	public ResponseEntity<HttpStatus> addPharmacistVacation(@RequestBody VacationInterval vacationInterval,@PathVariable Long pharmacistId)
		throws Exception 
	{
		VacationInterval v =vacationIntervalService.addPharmacistVacation(vacationInterval,pharmacistId);
		return v == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
    @GetMapping(value = "/getByPharmacy/{pharmacyId}")
	public ResponseEntity<List<VacationIntervalDTO>> getByPharmacy(@PathVariable Long pharmacyId) {
		List<VacationIntervalDTO> retVal = vacationIntervalService.getByPharmacyId(pharmacyId);
		return  retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@DeleteMapping(value = "/rejectVacationPharmacist/{pId}/{rId}/{reason}")
	  public boolean rejectVacationPharmacist(@PathVariable Long pId,@PathVariable Long rId,@PathVariable String reason) throws Exception{
		  return vacationIntervalService.rejectRequestPharmacist(pId,rId,reason);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@DeleteMapping(value = "/rejectVacationDermatologist/{dId}/{rId}/{reason}")
	  public boolean rejectDermatologist(@PathVariable Long dId,@PathVariable Long rId,@PathVariable String reason) throws Exception{
		  return vacationIntervalService.rejectRequestDermatologist(dId,rId,reason);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PutMapping(value = "/acceptVacationPharmacist/{pId/{rId}")
	  public boolean acceptVacationPharmacist(@PathVariable Long pId,@PathVariable Long rId) throws Exception{
		  return vacationIntervalService.acceptVacationPharmacist(pId,rId);
	}

	@PreAuthorize("hasRole('PHARMACYADMIN')")
	@PutMapping(value = "/acceptVacationDermatologist/{dId}/{rId}")
	  public boolean acceptDermatologist(@PathVariable Long dId,@PathVariable Long rId) throws Exception{
		  return vacationIntervalService.acceptVacationDermatologist(dId,rId);
	}
}
