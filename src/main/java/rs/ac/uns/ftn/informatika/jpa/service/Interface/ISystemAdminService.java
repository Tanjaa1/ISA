package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;

public interface ISystemAdminService {
    public ResponseEntity<SystemAdmin> save(SystemAdmin systemAdmin) throws Exception;
}
