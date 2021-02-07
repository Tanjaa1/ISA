package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {
    public List<Pharmacy> findAll();
    public List<Pharmacy> findPharmacyByNameAndPlace(String name,String place);
	public Set<MedicinePriceAndQuantity> getPharmacyMedicines(Long id);
    public ResponseEntity<Pharmacy> save(Pharmacy pharmacy) throws Exception;
    public Pharmacy getByName(String name);
}
