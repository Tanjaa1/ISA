package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {

    @Autowired
    IDermatologistRepository dermatologistRepository;

    @Override
    public List<DermatologistDTO> findAll() {
        DermatologistDTO dermatologistDTO = new DermatologistDTO();
        ArrayList<Dermatologist> dermatologists = dermatologistRepository.findAll();
        ArrayList<DermatologistDTO> returnValue = new ArrayList<DermatologistDTO>();
        for (Dermatologist dermatologist : dermatologists) {
            returnValue.add(dermatologistDTO.toDTO(dermatologist));
        }
        return returnValue;
    }





    
}
