package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.Supplier;

public interface ISupplierService {
   
    public ResponseEntity<Supplier> save(Supplier supplier) throws Exception;

    
}
