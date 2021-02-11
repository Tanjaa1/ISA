package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyAdminService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

 
    @Autowired
    private IPharmacyRepository pharmacyRepository;
    @Autowired
    private IMedicineRepository medicineRepository;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    
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

    public Pharmacy update(Pharmacy pharmacy){
        Pharmacy forUpdate = pharmacyRepository.getOne(pharmacy.getId());
        forUpdate.setId(pharmacy.getId());
        forUpdate.setMarks(pharmacy.getMarks());
        forUpdate.setName(pharmacy.getName());
        forUpdate.setPricelist(pharmacy.getPricelist());
        forUpdate.setAddress(pharmacy.getAddress());
        return pharmacyRepository.save(forUpdate);
    }


	public Pharmacy getByName(String name) {
        List<Pharmacy> pharmacies=findAll();
        Pharmacy result=new Pharmacy();
        for (Pharmacy s : pharmacies) {
            if(s.getName().equals(name)){
                result=s;
                return result;
            }
        }
        return null;
	}

    private Medicine findMedicine(String name){
        List<Medicine> medicines = medicineRepository.findAll();
        Medicine medicineFind = new Medicine();
		for (Medicine medicine : medicines) {
			if(medicine.getName().toUpperCase().contains(name.toUpperCase().trim()))
				medicineFind = medicine;
                break;
		}
        return medicineFind;
    }

	public List<PharmacyDTO> findPharmacyByMedicineName(String name) {
        Medicine medicineFind = findMedicine(name);
        List<PharmacyDTO> pharmacyList = new ArrayList<PharmacyDTO>();
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        for (Pharmacy pharmacy : pharmacies) {
            for (MedicinePriceAndQuantity medicine : pharmacy.getPricelist()) {
                if(medicine.getMedicine().getName() == medicineFind.getName() && medicine.getQuantity()>0){
                    pharmacyList.add(new PharmacyDTO(pharmacy));
                    break;
                }
            }
        }
		return pharmacyList;
	}

	public Pharmacy updateQuantity(Long id,Medicine medicine) {
        int quantity=0;
        Pharmacy pharmacy=pharmacyRepository.getOne(id);
        for (MedicinePriceAndQuantity m : pharmacy.getPricelist()) {
            if(m.getMedicine().getId() ==medicine.getId()){
                m.setQuantity(m.getQuantity()-1);
                quantity=m.getQuantity();
                break;
            }
        }
        Pharmacy p=update(pharmacy);
            try{
                if(quantity<2)
                pharmacyAdminService.sendingMail(pharmacy.getName(), medicine);
            }catch(Exception e){
            }
            finally{
                return p;
            }
        }
}
