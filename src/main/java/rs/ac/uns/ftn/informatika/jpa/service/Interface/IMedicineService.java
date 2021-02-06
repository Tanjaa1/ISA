package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineService {

	public Medicine findOne(Long id);
	public ResponseEntity<Medicine> save(Medicine patient) throws Exception;
}

