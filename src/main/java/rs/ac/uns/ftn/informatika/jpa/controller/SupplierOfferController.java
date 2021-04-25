package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.service.SupplierOfferService;
import rs.ac.uns.ftn.informatika.jpa.service.SupplierService;

@RestController
@RequestMapping(value = "/supplierOffer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierOfferController {
    
    @Autowired
    private SupplierOfferService supplierOfferService;


    @GetMapping(value = "/getOfferBySupplierId/{id}")
	public ResponseEntity<List<SupplierOffer>> getOfferBySupplierId(@PathVariable Long id) {
		List<SupplierOffer> usernames =supplierOfferService.getOfferBySupplierId(id);
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@GetMapping(value = "/filtrateOfferByStatus/{status}/{id}")
	public ResponseEntity<List<SupplierOffer>> filtrateOfferByStatus(@PathVariable String status,@PathVariable Long id) {
		List<SupplierOffer> usernames =supplierOfferService.filtrateOfferByStatus(status,id);
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
}
