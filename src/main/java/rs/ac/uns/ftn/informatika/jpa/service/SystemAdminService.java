package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISystemAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ISystemAdminService;

@Service
public class SystemAdminService implements ISystemAdminService {
    @Autowired
    private ISystemAdminRepository systemAdminRepository;

    public ResponseEntity<SystemAdmin> save(SystemAdmin systemAdmin) throws Exception {
        systemAdminRepository.save(systemAdmin);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    public List<SystemAdmin> getAll() {
        List<SystemAdmin> systemAdmins = systemAdminRepository.findAll();
           return systemAdmins;
   }

   public SystemAdmin findOne(Long id) {
    SystemAdmin systemAdmin = systemAdminRepository.getOne(id);
       return systemAdmin;
    }

    public List<String> getAllSystemAdinUsernames() {
        List<SystemAdmin> systemAdmins = systemAdminRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (SystemAdmin s : systemAdmins) {
            resultList.add(s.getUsername());
        }
        return resultList;
    }

	public Boolean isUsernameValid(String username) {
		List<String> usernames=getAllSystemAdinUsernames();
        for (String s : usernames) {
            if(s.equals(username))
                return false;
        }
        return true;
	}
    
}
