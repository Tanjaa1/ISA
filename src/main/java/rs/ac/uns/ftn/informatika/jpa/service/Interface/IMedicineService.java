package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineService {
	List<Medicine> findAll();
}
