package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRpository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IMedicineService;

@Service
public class MedicineService implements IMedicineService {

    @Autowired
	private IMedicineRpository medicineRpository;

    @Override
    public List<Medicine> findAll() {
        return medicineRpository.findAll();
    }
    
}
