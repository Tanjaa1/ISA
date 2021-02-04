package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {
    public List<Pharmacy> findAll();
}
