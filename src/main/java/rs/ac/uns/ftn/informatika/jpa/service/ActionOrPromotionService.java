package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IActionOrPromotionRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IActionOrPromotionService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;
import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;

@Service
public class ActionOrPromotionService implements IActionOrPromotionService {

    @Autowired
    private IActionOrPromotionRepository actionOrPromotionRepository;
    @Autowired
    private IPatientRepository patientRepository;   
    @Autowired
    private IMedicineRepository medicineService;   
	@Autowired
	private EmailService emailService;
	@Autowired
	private IPharmacyRepository pharmacyService;
    @Autowired
	private PatientService patientService;

    
    public List<ActionOrPromotionsDTO> getAll() {
        List<ActionOrPromotion> actionOrPromotions = actionOrPromotionRepository.findAll();
        List<ActionOrPromotionsDTO> resultList =new ArrayList<ActionOrPromotionsDTO>();
        for (ActionOrPromotion actionOrPromotion : actionOrPromotions) {
               resultList.add(new ActionOrPromotionsDTO(actionOrPromotion));
        }
        if(resultList.isEmpty())
        return null;
    else
        return resultList;
    }

    @Override
    public ActionOrPromotionsDTO save(ActionOrPromotion actionOrPromotion) {
        ActionOrPromotion newActionPromotion = new ActionOrPromotion();  
        newActionPromotion.setPharmacy(pharmacyService.getOne(actionOrPromotion.getPharmacy().getId()));
        newActionPromotion.setText(actionOrPromotion.getText());
        newActionPromotion.setMedicine(medicineService.getMedicinebyName(actionOrPromotion.getMedicine().getName()));
        newActionPromotion.setEndTime(actionOrPromotion.getEndTime());
        newActionPromotion.setStartTime(actionOrPromotion.getStartTime());
        emailSender(newActionPromotion);
        return new ActionOrPromotionsDTO(actionOrPromotionRepository.save(newActionPromotion));
    }

    private void emailSender(ActionOrPromotion actionOrPromotion)
	{
		try {
            Pharmacy p = pharmacyService.getOne(actionOrPromotion.getPharmacy().getId());
            Set<Patient> patients= p.getSubscribedUsers();
			String subject="New action in "+ p.getName();
			String text= actionOrPromotion.getText();
            for (Patient patient : patients) {
			    emailService.sendNotificaitionAsync(patient.getEmail(), subject, text);
            }
		}catch( Exception e ){
			System.out.println("Error sending email: " + e.getMessage());
		}
	}

    @Override
    public List<ActionOrPromotionsDTO> getByPharmacyId(String id) {
        Long idActionOrPromotion=Integer.toUnsignedLong(Integer.valueOf(id));
        List<ActionOrPromotion> actionOrPromotions = actionOrPromotionRepository.findAll();
        List<ActionOrPromotionsDTO> resultList =new ArrayList<ActionOrPromotionsDTO>();
        for (ActionOrPromotion actionOrPromotion : actionOrPromotions) {
           if(actionOrPromotion.getPharmacy().getId()==idActionOrPromotion){
               resultList.add(new ActionOrPromotionsDTO(actionOrPromotion));
           }
        }
        if(resultList.isEmpty())
            return null;
        else
            return resultList;

       }

    @Override
    public ActionOrPromotionsDTO findById(Long Id) {
        ActionOrPromotion aop=actionOrPromotionRepository.findById(Id).get();
        return new ActionOrPromotionsDTO(aop);
    }

    @Override
    public List<ActionOrPromotionsDTO> getAllUnsubscribed(Long id) {
        List<ActionOrPromotionsDTO> all=getAll();
        Set<ActionOrPromotionsDTO> subscribed=patientService.getAllActionsAndPromotionByPatientId(id.toString(id));
        Set<ActionOrPromotionsDTO> resultList=new HashSet<>();
        for (ActionOrPromotionsDTO actionOrPromotionsDTO : all) {
            for (ActionOrPromotionsDTO actionOrPromotionsDTO2 : subscribed) {
                if(!actionOrPromotionsDTO2.equals(actionOrPromotionsDTO)){
                    resultList.add(actionOrPromotionsDTO);
                }
            }
            
        }
        for (ActionOrPromotionsDTO actionOrPromotionsDTO : resultList) {
            all.remove(actionOrPromotionsDTO);
        }
       
        if(all.isEmpty())
        return null;
    else
        return all;

    }

  

   
   

}
