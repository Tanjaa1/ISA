package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;

public interface ISupplierService {
   
    public ResponseEntity<SupplierDTO> save(Supplier supplier) throws Exception;
	SupplierDTO update(SupplierDTO supplier) throws Exception;

    
}
