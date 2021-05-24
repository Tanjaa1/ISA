package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;
import java.util.Set;

import javax.swing.text.StyledEditorKit.BoldAction;

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

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/saveSupplier")
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplierDTO) throws Exception{
		supplierService.save(supplierDTO);
    return new ResponseEntity<>(supplierDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllSupplierUsernames")
	public ResponseEntity<List<String>> getAllSupplierUsernames() {
		List<String> usernames =supplierService.getAllSupplierUsernames();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@PreAuthorize("hasRole('SUPPLIER')")
    @GetMapping(value = "/firtTimeLogin/{username}")
	public Boolean firtTimeLogin(@PathVariable String username) {
		Boolean result =supplierService.firtTimeLogin(username);
		return result ;
	}
	
	@GetMapping(value = "/getById/{supplierId}")
	public ResponseEntity<SupplierDTO> getById(@PathVariable Long supplierId) {
		SupplierDTO usernames =new SupplierDTO(supplierService.findOne(supplierId));
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}

	@GetMapping(value = "/getAllSuppliers")
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		List<Supplier> usernames =supplierService.getAll();
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}
	@GetMapping(value = "/getAllSuppliersStokcs/{supplierId}")
	public ResponseEntity<Set<MedicineQuantityDTO>> getAllSuppliersStokcs(@PathVariable Long supplierId) {
		Set<MedicineQuantityDTO> usernames =supplierService.getAllSuppliersStokcs(supplierId);
		return usernames == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(usernames);
	}

	@PreAuthorize("hasRole('SUPPLIER')")
	@PutMapping(value = "/update")
	public ResponseEntity<SupplierDTO> updateGreeting(@RequestBody SupplierDTO supplier) throws Exception {	
		SupplierDTO p = supplierService.update(supplier);
		return p == 
		null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(p);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/isUsernameValid/{username}")
	public ResponseEntity<Boolean> isUsernameValid(@PathVariable String username) {
		Boolean isValid = supplierService.isUsernameValid(username);
		return isValid == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isValid);
	}

	@PutMapping(value ="/confirmationEmailsupplier/{supplierId}")
	public ResponseEntity<Boolean> confirmationEmail(@PathVariable String supplierId) throws Exception {
		Boolean success = supplierService.confirmationEmail(Long.parseLong(supplierId));
		return success == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(success);
	}

	@PreAuthorize("hasRole('SUPPLIER')")
	@GetMapping(value = "/getSupplierByCredentials/{username}")
	public ResponseEntity<SupplierDTO> getPatientByCredgetSupplierByCredentialsentials(@PathVariable String username) {
		SupplierDTO patient = new SupplierDTO(supplierService.getSupplierByCredentials(username));
		return patient == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patient);
	}

}
