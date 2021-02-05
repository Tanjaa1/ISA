package rs.ac.uns.ftn.informatika.jpa.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;



import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {


	@Autowired
	private IDermatologistRepository dermatologistRepository;

	public Dermatologist findOne(Long id) 
	{
		 return dermatologistRepository.getOne(id);
	}

	@Override
    public Dermatologist update(Dermatologist dermatologist) throws Exception 
	{
        Dermatologist dermatolgist1 = findOne(dermatologist.getId());
        if (dermatolgist1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
		dermatolgist1.setId(dermatologist.getId());
		dermatolgist1.setName(dermatologist.getName());
		dermatolgist1.setSurname(dermatologist.getSurname());
		dermatolgist1.setEmail(dermatologist.getEmail());
		dermatolgist1.setPassword(dermatologist.getPassword());
		dermatolgist1.setAddress(dermatologist.getAddress());
		dermatolgist1.setCity(dermatologist.getCity());
		dermatolgist1.setCountry(dermatologist.getCountry());
		dermatolgist1.setPhoneNumber(dermatologist.getPhoneNumber());
		dermatolgist1.setEmailComfirmed(dermatologist.getEmailComfirmed());
		dermatolgist1.setFirstTimeLogin(dermatologist.getFirstTimeLogin());
		dermatolgist1.setDescription(dermatologist.getDescription());
        return dermatologistRepository.save(dermatolgist1);
    }
  
   @Override
    public List<DermatologistDTO> findAll() {
        DermatologistDTO dermatologistDTO = new DermatologistDTO();
        List<Dermatologist> dermatologists = dermatologistRepository.findAll();
        List<DermatologistDTO> returnValue = new ArrayList<DermatologistDTO>();
        for (Dermatologist dermatologist : dermatologists)
            returnValue.add(dermatologistDTO.toDTO(dermatologist));
        return returnValue;
    }

}
