package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistService {
    
	public Pharmacist findOne(Long id);
	Pharmacist update(Pharmacist pharmacist) throws Exception;
}
