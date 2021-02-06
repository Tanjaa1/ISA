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
    private IPharmacyRepository pharmacyRepository;
    
    public List<Pharmacy> findAll(){
        return pharmacyRepository.findAll();
    }

    public List<Pharmacy> findPharmacyByNameAndPlace(String name,String place) {	
		List<Pharmacy> pharmaciesFind = new ArrayList<Pharmacy>();
        List<Pharmacy> pharmacies = findAll();
		for (Pharmacy pharmacy : pharmacies) {
			if(pharmacy.getName().toUpperCase().contains(name.toUpperCase().trim()) && isContainPlace(pharmacy,place))
				pharmaciesFind.add(pharmacy);
		}
		return pharmaciesFind;
	}

    public Boolean isContainPlace(Pharmacy pharmacy, String place){
        String[] p = pharmacy.getAddress().split(",");
        if(p[1].toUpperCase().contains(place.toUpperCase().trim())){
            return true;
        }else{
            return false;
        }
    } 
}
