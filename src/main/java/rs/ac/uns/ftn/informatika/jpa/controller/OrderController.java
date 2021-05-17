package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRequestDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.service.OrderService;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
    @Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<OrderDTO>> getAll() {
		List<OrderDTO> retVal = orderService.findAll();
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@GetMapping(value = "/getRequestsByPharmacyUnsolved/{Id}")
	public ResponseEntity<List<MedicineRequestDTO>> getRequestsByPharmacyUnsolved(@PathVariable Long Id) {
		List<MedicineRequestDTO> retVal = orderService.getRequestByPharmacy(Id);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}

	@GetMapping(value = "/ordersByPharmacyId/{Id}")
	public ResponseEntity<List<OrderDTO>> getOrdersByPharmacyId(@PathVariable Long Id) {
		List<OrderDTO> retVal = orderService.getByPharmacyId(Id);
		return retVal == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(retVal);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) throws Exception{
		orderService.save(order);
	return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	@PostMapping(value = "/addRequest")
	public ResponseEntity<MedicineRequestDTO> addRequest(@RequestBody MedicineRequestDTO request) throws Exception{
		orderService.addRequest(request);
	return new ResponseEntity<>(request, HttpStatus.CREATED);
	}

	@PutMapping(value = "/setRequestToSolved/{Id}")
	public ResponseEntity<MedicineRequestDTO> setRequestToSolved(@PathVariable Long Id) throws Exception{	
	return new ResponseEntity<>(new MedicineRequestDTO(orderService.setRequestToSolved(Id)), HttpStatus.CREATED);
	}
}
