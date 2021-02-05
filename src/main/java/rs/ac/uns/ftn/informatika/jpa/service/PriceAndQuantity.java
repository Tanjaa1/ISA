package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPriceAndQuantityRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPriceAndQuantity;

public class PriceAndQuantity implements IPriceAndQuantity {

    @Autowired
    private IPriceAndQuantityRepository priceAndQuantityRepository;
    
    @Override
    public List<MedicinePriceAndQuantity> findAll(){
        return priceAndQuantityRepository.findAll();
    }

    @Override
    public MedicinePriceAndQuantity update(MedicinePriceAndQuantity medicinePriceAndQuantity) throws Exception {
        return priceAndQuantityRepository.save(medicinePriceAndQuantity);
    }
}
