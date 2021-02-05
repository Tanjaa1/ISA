package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;


import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;

public interface IDermatologistService {
    List<DermatologistDTO> findAll();
}
