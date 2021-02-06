package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public interface IPharmacyAdminService {

    public ResponseEntity<PharmacyAdmin> save(PharmacyAdmin pharmacyAdmin) throws Exception;
}
