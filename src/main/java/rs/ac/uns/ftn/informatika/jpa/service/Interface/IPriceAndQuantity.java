package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;

public interface IPriceAndQuantity {
    public List<MedicinePriceAndQuantity> findAll();
	MedicinePriceAndQuantity update(MedicinePriceAndQuantity medicinePriceAndQuantity) throws Exception;   
}
