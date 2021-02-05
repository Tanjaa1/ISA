package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

    @Autowired
    IPharmacyRepository pharmacyRepository;

    @Override
    public List<PharmacyDTO> findAll() {
        PharmacyDTO PharmacyDTO = new PharmacyDTO();
        ArrayList<Pharmacy> pharmacies = pharmacyRepository.findAll();
        ArrayList<PharmacyDTO> returnValue = new ArrayList<PharmacyDTO>();
        for (Pharmacy pharmacy : pharmacies) {
            returnValue.add(PharmacyDTO.toDto(pharmacy));
        }
        return returnValue;
    }
    
}
