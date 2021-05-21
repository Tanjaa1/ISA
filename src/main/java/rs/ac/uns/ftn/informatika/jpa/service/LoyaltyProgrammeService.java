package rs.ac.uns.ftn.informatika.jpa.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.LoyaltyProgrammeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ILoyaltyProgrammeRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ILoyaltyProgrammeService;
@Service
public class LoyaltyProgrammeService implements ILoyaltyProgrammeService {
    @Autowired
	private ILoyaltyProgrammeRepository loyaltyProgrammeRepository;
	
    public void save(LoyaltyProgramme loyaltyProgramme) {
        List<LoyaltyProgramme> list=loyaltyProgrammeRepository.findAll();
        if(list.size()>0){
            loyaltyProgrammeRepository.deleteAll();
        }else{
            LoyaltyProgramme loyaltyProgramme2 = new LoyaltyProgramme();
            loyaltyProgramme2.setId(loyaltyProgramme.getId());
            loyaltyProgramme2.setRegular(loyaltyProgramme.getRegular());
            loyaltyProgramme2.setSilver(loyaltyProgramme.getSilver());
            loyaltyProgramme2.setGold(loyaltyProgramme.getGold());
            loyaltyProgramme2.setRegularDiscount(loyaltyProgramme.getRegularDiscount());
            loyaltyProgramme2.setSilverDiscount(loyaltyProgramme.getSilverDiscount());
            loyaltyProgramme2.setGoldDiscount(loyaltyProgramme.getGoldDiscount());
    
            loyaltyProgrammeRepository.save(loyaltyProgramme2);
        }
    }

    public LoyaltyProgramme findById(Long id){
        List<LoyaltyProgramme> lpdts=loyaltyProgrammeRepository.findAll();
        LoyaltyProgramme result=new LoyaltyProgramme();
        for (LoyaltyProgramme loyaltyProgramme : lpdts) {
            if(loyaltyProgramme.getId()==id){
                result=loyaltyProgramme;
            }
        }
        return result;

    }   
     public LoyaltyProgrammeDTO update(LoyaltyProgramme loyaltyProgramme) throws Exception {
        LoyaltyProgramme loyaltyProgramme1 = findById(loyaltyProgramme.getId());
        if (loyaltyProgramme1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		loyaltyProgramme1.setId(loyaltyProgramme.getId());
		loyaltyProgramme1.setRegular(loyaltyProgramme.getRegular());
		loyaltyProgramme1.setSilver(loyaltyProgramme.getSilver());
		loyaltyProgramme1.setPointsForCounceling(loyaltyProgramme.getPointsForCounceling());
        loyaltyProgramme1.setPointsForExamination(loyaltyProgramme.getPointsForExamination());
		loyaltyProgramme1.setGold(loyaltyProgramme.getGold());
        loyaltyProgramme1.setRegularDiscount(loyaltyProgramme.getRegularDiscount());
        loyaltyProgramme1.setSilverDiscount(loyaltyProgramme.getSilverDiscount());
        loyaltyProgramme1.setGoldDiscount(loyaltyProgramme.getGoldDiscount());

        LoyaltyProgramme loyaltyProgramme2 = loyaltyProgrammeRepository.save(loyaltyProgramme1);
        return new LoyaltyProgrammeDTO(loyaltyProgramme2);
    }

    public List<LoyaltyProgrammeDTO> getAll(){
        List<LoyaltyProgramme> loyaltyProgramme1 = loyaltyProgrammeRepository.findAll();
        List<LoyaltyProgrammeDTO> result=new ArrayList<>();
        for (LoyaltyProgramme loyaltyProgramme : loyaltyProgramme1) {
            result.add(new LoyaltyProgrammeDTO(loyaltyProgramme));
        }
        return result;
    }

    
    public LoyaltyProgrammeDTO getLP() {
        List<LoyaltyProgrammeDTO> lp=getAll();
        LoyaltyProgrammeDTO lpp= lp.get(0);   
    return lpp;
 }
    
}
