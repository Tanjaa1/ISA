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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.SupplierOfferDTO;
import rs.ac.uns.ftn.informatika.jpa.service.SupplierOfferService;

@RestController
@RequestMapping(value = "/supplierOffer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierOfferController {
    
    @Autowired
    private SupplierOfferService supplierOfferService;

	@PreAuthorize("hasRole('SUPPLIER')")
    @GetMapping(value = "/getOfferBySupplierId/{id}")
	public ResponseEntity<List<SupplierOfferDTO>> getOfferBySupplierId(@PathVariable Long id) {
		List<SupplierOfferDTO> usernames =supplierOfferService.getOfferBySupplierId(id);
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/getOrdersByOrderId/{orderId}")
	public Set<MedicineQuantityDTO> getOrdersByOrderId(@PathVariable Long orderId) {
		Set<MedicineQuantityDTO> usernames =supplierOfferService.getOrdersByOrderId(orderId);
		return usernames ;
	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/filtrateOfferByStatus/{status}/{id}")
	public List<SupplierOfferDTO> filtrateOfferByStatus(@PathVariable String status,@PathVariable Long id) {
		List<SupplierOfferDTO> usernames =supplierOfferService.filtrateOfferByStatus(status,id);
		return usernames ;
	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/giveOfferToOrder/{orderId}/{supplierId}/{price}/{dueDate}")
	public Boolean giveOfferToOrder(@PathVariable  double price,@PathVariable  String dueDate, @PathVariable Long orderId,@PathVariable Long supplierId) throws Exception {
		Boolean offerS =supplierOfferService.giveOfferToOrder(price,dueDate,orderId,supplierId);
		return offerS;

	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/isOfferGivenToOrder/{orderId}/{supplierId}")
	public Boolean isOfferGivenToOrder(@PathVariable Long orderId,@PathVariable Long supplierId) throws Exception {
		Boolean offerS =supplierOfferService.isOfferGivenToOrder(orderId,supplierId);
		return offerS;

	}
	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/getOffersByOrder/{orderId}")
	public List<SupplierOfferDTO> getOffersByOrder(@PathVariable Long orderId) throws Exception {

		return supplierOfferService.getByOrder(orderId);

	}
	@PutMapping(value = "/acceptOffer/{id}")
	public Boolean accepOffer(@RequestBody OrderDTO order,@PathVariable Long id) throws Exception {

		return supplierOfferService.acceptOrder(order,id);

	}
}
