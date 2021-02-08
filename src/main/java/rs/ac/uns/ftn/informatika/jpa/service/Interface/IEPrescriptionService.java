package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;

public interface IEPrescriptionService {
    
	public EPrescription findOne(Long id);
	EPrescription save(EPrescription ePrescription,Long id) throws Exception;
  	List<EPrescription> findAll();
}
