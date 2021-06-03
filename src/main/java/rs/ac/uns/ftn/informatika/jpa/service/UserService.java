package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;

import rs.ac.uns.ftn.informatika.jpa.dto.SupplierDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserRequest;
import rs.ac.uns.ftn.informatika.jpa.repository.PharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IUserRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IUserService;

@Service
public class UserService implements IUserService{


	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Autowired
	private IPharmacyAdminRepository pharmacyAdminRepository;
	
	@Override
	public Collection<User> allUsers() {
		return null;
	}

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
	return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}

	@Override
	public User save(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		// pre nego sto postavimo lozinku u atribut hesiramo je
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setName(userRequest.getFirstname());
		u.setSurname(userRequest.getLastname());
		u.setEnabled(true);
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		u.setAuthorities(auth);
		
		u = this.userRepository.save(u);
		return u;
	}
	public Boolean isUsernameValid(String username) {
        List<User> usernames=findAll();
		for (User user : usernames) {
			if(user.getUsername().equals(username)){
                return false;

			}
		}
        
        return true;
	}
    public void saveUserByPatient(Patient user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_USER");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);

	}

    public void saveUserBySupplier(Supplier user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_SUPPLIER");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }

	public void saveUserBySystemAdmin(SystemAdmin user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_ADMIN");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
	}

    public void saveUserByPharmacyAdmin(PharmacyAdminDTO user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_PHARMACYADMIN");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }

    public void saveUserByPharmacist(Pharmacist user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_PHARMACIST");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }

    public void saveUserByDermatologist(Dermatologist user) {
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_DERMATOLOGIST");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }
	

    public void updateUserBySupplier(SupplierDTO user) throws Exception {
		User u = userRepository.getOne(user.getId());
        if (u == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_SUPPLIER");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }

    public void updateUserBySystemAdmin(SystemAdmin user) throws Exception {
		User u = userRepository.getOne(user.getId());
        if (u == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		u.setId(user.getId());
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setAddress(user.getAddress());
		u.setCity(user.getCity());
		u.setCountry(user.getCountry());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmailComfirmed(user.getEmailComfirmed());
		u.setFirstTimeLogin(user.getFirstTimeLogin());
		u.setDescription(user.getDescription()); 
		u.setEnabled(true);
		u.setLastPasswordResetDate(new Date());
		u.setFirstTimeLogin(false);
		u.setUsername(user.getUsername());
		List<Authority> auth = authService.findByname("ROLE_ADMIN");
		u.setAuthorities(auth);	
		u = this.userRepository.save(u);
    }
    
	
}