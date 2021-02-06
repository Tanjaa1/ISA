package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Pharmacy> save(Pharmacy pharmacy) throws Exception {
        pharmacyRepository.save(pharmacy);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    public List<Pharmacy> getAll() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
           return pharmacies;
   }
   public Pharmacy findOne(Long id) {
    Pharmacy pharmacy = pharmacyRepository.getOne(id);
       return pharmacy;
    }

    public List<String> getAllPharmacyNames() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Pharmacy s : pharmacies) {
            resultList.add(s.getName());
        }
        return resultList;
    }

    public Boolean isNameValid(String name) {
        List<String> names=getAllPharmacyNames();
        for (String s : names) {
            if(s.equals(name))
                return false;
        }
        return true;
    }
    
    public Set<MedicinePriceAndQuantity> getPharmacyMedicines(Long id) {
        return findOne(id).getPricelist();
    }
    
}
