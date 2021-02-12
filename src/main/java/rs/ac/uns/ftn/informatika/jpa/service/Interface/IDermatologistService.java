package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;

public interface IDermatologistService {

	public Dermatologist findOne(Long id);
	Dermatologist update(Dermatologist dermatologist) throws Exception;
  	List<DermatologistDTO> findAll();
	public ResponseEntity<Dermatologist> save(Dermatologist dermatologist) throws Exception;
	public List<DermatologistDTO> getDermatologists(Long id);

}
