package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

 
    @Autowired
    private IPharmacyRepository pharmacyRepository;
    
    public List<Pharmacy> findAll(){
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy findOne(Long id) {
        return pharmacyRepository.getOne(id);
    }

    @Override
    public Set<MedicinePriceAndQuantity> getPharmacyMedicines(Long id) {
        return findOne(id).getPricelist();
    }
    

}
