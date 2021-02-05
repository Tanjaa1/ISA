package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistService {
    
	public Pharmacist findOne(Long id);
	Pharmacist update(Pharmacist pharmacist) throws Exception;
	List<PharmacistDTO> findAll();

}
