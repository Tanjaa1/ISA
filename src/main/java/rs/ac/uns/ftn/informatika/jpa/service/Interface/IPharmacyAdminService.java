package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public interface IPharmacyAdminService {

    public ResponseEntity<PharmacyAdmin> save(PharmacyAdmin pharmacyAdmin) throws Exception;
    Boolean sendingMail(String pharmacyName,Medicine medicine);
}
