package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.service.ResrvationService;

@RestController
@RequestMapping(value = "/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {
    
	@Autowired
	private ResrvationService reservationService;
	
	@GetMapping(value = "/getReservationById/{id}")
	public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
		ReservationDTO reservation = reservationService.findOne(id);
		return reservation == null ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.ok(reservation);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<HttpStatus> updateReservation(@RequestBody ReservationDTO reservationDTO) throws Exception {
		ReservationDTO reservation = new ReservationDTO(reservationService.updateReservation(reservationDTO.getId()));
		return reservation == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
	}

}
