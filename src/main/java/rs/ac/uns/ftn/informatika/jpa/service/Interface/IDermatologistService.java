package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;

public interface IDermatologistService {

	public Dermatologist findOne(Long id);
	Dermatologist update(Dermatologist dermatologist) throws Exception;
}
