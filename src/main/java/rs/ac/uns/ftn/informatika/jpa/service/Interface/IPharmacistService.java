package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistService {
    
	public Pharmacist findOne(Long id);
	Pharmacist update(Pharmacist pharmacist) throws Exception;
	List<PharmacistDTO> findAll();
	public List<PharmacyDTO> gPharmaciesByPharmaciest(LocalDateTime startTime);
	public List<PharmacistDTO> getPharmacistByPharmacyId(Long id);

}
