package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.service.VacationIntervalService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IVacationIntervalService;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

@RestController
@RequestMapping(value = "/vacation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VacationIntervalController {
      
	@Autowired
	private IVacationIntervalService vacationIntervalService;

    @PostMapping(value = "/addDermatologistVacation/{dermatologistId}")
	public ResponseEntity<HttpStatus> addDermatologistVacation(@RequestBody VacationInterval vacationInterval,@PathVariable Long dermatologistId)
		throws Exception 
	{
		VacationInterval v =vacationIntervalService.addDermatologististVacation(vacationInterval,dermatologistId);
		return v == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

    @PostMapping(value = "/addPharmacistVacation/{pharmacistId}")
	public ResponseEntity<HttpStatus> addPharmacistVacation(@RequestBody VacationInterval vacationInterval,@PathVariable Long pharmacistId)
		throws Exception 
	{
		VacationInterval v =vacationIntervalService.addPharmacistVacation(vacationInterval,pharmacistId);
		return v == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}
}
