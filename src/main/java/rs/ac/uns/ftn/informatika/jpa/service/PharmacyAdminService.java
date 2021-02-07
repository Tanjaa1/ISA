package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyAdminService;

@Service
public class PharmacyAdminService implements IPharmacyAdminService {
    @Autowired
    private IPharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    private EmailService emailService;
    public ResponseEntity<PharmacyAdmin> save(PharmacyAdmin systemAdmin) throws Exception {
        pharmacyAdminRepository.save(systemAdmin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<PharmacyAdmin> getAll() {
        List<PharmacyAdmin> systemAdmins = pharmacyAdminRepository.findAll();
        return systemAdmins;
    }

    public PharmacyAdmin findOne(Long id) {
        PharmacyAdmin systemAdmin = pharmacyAdminRepository.getOne(id);
        return systemAdmin;
    }

    public List<String> getAllSystemAdminUsernames() {
        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminRepository.findAll();
        List<String> resultList = new ArrayList<String>();
        for (PharmacyAdmin s : pharmacyAdmins) {
            resultList.add(s.getUsername());
        }
        return resultList;
    }

    public Boolean isUsernameValid(String username) {
        List<String> usernames = getAllSystemAdminUsernames();
        for (String s : usernames) {
            if (s.equals(username))
                return false;
        }
        return true;
    }
    
    public Boolean sendingMail(String pharmacyName,Medicine medicine)
    {
        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminRepository.findAll();  
        for (PharmacyAdmin pharmacyAdmin : pharmacyAdmins) {
            if(pharmacyAdmin.getPharmacy().equals(pharmacyName)){
                try{
                    String subject="Medicine";
                    String text="Dear "+ pharmacyAdmin.getName()+" "+pharmacyAdmin.getSurname()+ ",\nNeed medicine:"+medicine.getName();
                    emailService.sendNotificaitionAsync(pharmacyAdmin.getEmail(), subject, text);
                }catch(Exception e){
                        return false;
                }
            }
        }
        return true;
	}
}