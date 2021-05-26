package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;
import java.util.Set;

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

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.service.ResrvationService;

@RestController
@RequestMapping(value = "/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {
    
	@Autowired
	private ResrvationService reservationService;
	
	@PreAuthorize("hasRole('PHARMACIST')")
	@GetMapping(value = "/getReservationById/{id}/{pharmacyId}")
	public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id,@PathVariable Long pharmacyId) 
	{
		ReservationDTO reservation = reservationService.getReservationById(id,pharmacyId);
		return reservation == null ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.ok(reservation);
	}

	@PreAuthorize("hasRole('PHARMACIST')")
	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody Reservation reservation) throws Exception 
	{
		ReservationDTO r = new ReservationDTO(reservationService.updateReservation(reservation.getId()));
		return r == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getNotReceivedReservationByPatientId/{id}")
	public ResponseEntity<List<ReservationDTO>> getNotReceivedReservationByPatientId(@PathVariable Long id) 
	{	
		List<ReservationDTO> reservations = reservationService.getAllByPatientId(id);
		return reservations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(reservations);
	}

	@GetMapping(value = "/getReceivedReservationByPatientId/{id}")
	public ResponseEntity<List<ReservationDTO>> getReceivedReservationByPatientId(@PathVariable Long id) 
	{	
		List<ReservationDTO> reservations = reservationService.getAllReceivedByPatientId(id);
		return reservations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(reservations);
	}
	@GetMapping(value = "/getPharmaciesOfReceivedReservationByPatientId/{id}")
	public ResponseEntity<Set<PharmacyDTO>> getPharmaciesOfReceivedReservationByPatientId(@PathVariable Long id) throws Exception
	{	
		Set<PharmacyDTO> reservations = reservationService.getPharmaciesOfReceivedReservationByPatientId(id);
		return reservations == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(reservations);
	}

	@PutMapping(value = "/cancelReservation")
	public ResponseEntity<HttpStatus> cancelReservation(@RequestBody Reservation reservation) throws Exception 
	{
		Reservation r = reservationService.updateReservationIsCancel(reservation);
		return r == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/makeReservation")
	public ResponseEntity<ReservationDTO> updateReservation(@RequestBody Reservation reservation) throws Exception 
	{
		return ResponseEntity.ok(reservationService.makeReservation(reservation));
	}

	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping(value = "/makeNewReservation")
	public ResponseEntity<ReservationDTO> createReservation(@RequestBody Reservation reservation) throws Exception 
	{
		return ResponseEntity.ok(reservationService.makeNewReservation(reservation));
	}

}
