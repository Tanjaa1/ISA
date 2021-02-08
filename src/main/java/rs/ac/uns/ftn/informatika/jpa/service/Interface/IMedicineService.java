package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;

public interface IMedicineService {

	public Medicine findOne(Long id);
	public ResponseEntity<Medicine> save(Medicine patient) throws Exception;
	ArrayList<Medicine> findAll();
}

