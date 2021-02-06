package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ISupplierService;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;
    
    
    public ResponseEntity<Supplier> save(Supplier supplier) throws Exception {
        supplierRepository.save(supplier);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

	public List<String> getAllSupplierUsernames() {
		List<Supplier> suppliers = supplierRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Supplier s : suppliers) {
            resultList.add(s.getUsername());
        }
        return resultList;
	}

	public Boolean isUsernameValid(String username) {
		List<String> usernames=getAllSupplierUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}
    
}
