package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;

public interface IPharmacyService {
    List<PharmacyDTO> findAll();

}
