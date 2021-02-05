package rs.ac.uns.ftn.informatika.jpa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacistService;

@Service
public class PharmacistService implements IPharmacistService {

	@Autowired
	private IPharmacistRepository pharmacistRepository;

	public Pharmacist findOne(Long id) {
		 return pharmacistRepository.getOne(id);
	}

	@Override
    public Pharmacist update(Pharmacist pharmacist) throws Exception {
        Pharmacist pharmacist1 = findOne(pharmacist.getId());
        if (pharmacist1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		pharmacist1.setId(pharmacist.getId());
		pharmacist1.setName(pharmacist.getName());
		pharmacist1.setSurname(pharmacist.getSurname());
		pharmacist1.setEmail(pharmacist.getEmail());
		pharmacist1.setPassword(pharmacist.getPassword());
		pharmacist1.setAddress(pharmacist.getAddress());
		pharmacist1.setCity(pharmacist.getCity());
		pharmacist1.setCountry(pharmacist.getCountry());
		pharmacist1.setPhoneNumber(pharmacist.getPhoneNumber());
		pharmacist1.setEmailComfirmed(pharmacist.getEmailComfirmed());
		pharmacist1.setFirstTimeLogin(pharmacist.getFirstTimeLogin());
		pharmacist1.setDescription(pharmacist.getDescription());
        return pharmacistRepository.save(pharmacist1);
    }
}
