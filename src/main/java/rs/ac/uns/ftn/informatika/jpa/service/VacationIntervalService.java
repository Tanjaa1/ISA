package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.dto.VacationIntervalDTO;

import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IVacationIntervalRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IVacationIntervalService;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

@Service
public class VacationIntervalService implements IVacationIntervalService{
    @Autowired
    private IVacationIntervalRepository vacationIntervalRepository;

    @Autowired
    private IDermatologistRepository dermatologistRepository;

    @Autowired
    private IPharmacyRepository pharmacyRepository;

    @Autowired
	private EmailService emailService;
    
    @Autowired
    private IPharmacistRepository pharmacistRepository;

    public VacationInterval add(VacationInterval vacationInterval)
    {
        VacationInterval v=new VacationInterval();
        v.setDateStart(vacationInterval.getDateStart());
        v.setDateEnd(vacationInterval.getDateEnd());
        v.setPharmacyId(vacationInterval.getPharmacyId());
        return vacationIntervalRepository.save(v);
    }

    @Override
    public VacationInterval addPharmacistVacation(VacationInterval vacationInterval, Long id) throws Exception 
    {
        VacationInterval v=add(vacationInterval);
        Pharmacist pharmacist=pharmacistRepository.getOne(id);
        try{
            pharmacist.getVacationSchedule().add(v);
            pharmacistRepository.save(pharmacist);
       }catch(Exception ex){
           throw new Exception("Error.");
       }
        return v;
    }

    @Override
    public VacationInterval addDermatologististVacation(VacationInterval vacationInterval, Long id) throws Exception
    {
        VacationInterval v=add(vacationInterval);
        Dermatologist dermatologist=dermatologistRepository.getOne(id);
        try{
            dermatologist.getVacationSchedule().add(v);
            dermatologistRepository.save(dermatologist);
       }catch(Exception ex){
           throw new Exception("Error.");
       }
        return v;
    }

    @Override
    public List<VacationIntervalDTO> getByPharmacyId(Long pId)  {

        List<VacationIntervalDTO> retVal = new ArrayList<VacationIntervalDTO>();
        for (VacationInterval v: vacationIntervalRepository.getByPharmacyId(pId)){
            retVal.add(new VacationIntervalDTO(v));
        }

        return retVal;
    }

    @Override
    public Boolean rejectRequestPharmacist(Long pId, Long rId,String reason) {

            Pharmacist p = pharmacistRepository.getById(pId);
            VacationInterval vi = vacationIntervalRepository.getOne(rId);
    try{
            String subject="Response to vacation request \n\n";
            String text="We are informing you that your vacation request from " + vi.getDateStart() + " to " + vi.getDateEnd() + "in pharmacy " + pharmacyRepository.getOne(vi.getPharmacyId()).getName() + " is rejected.\n" + reason;
            emailService.sendNotificaitionAsync(pharmacistRepository.getOne(pId).getEmail(),subject,text);


        }
        catch(Exception e){
            return false;
        }

        Set<VacationInterval> newVal =new HashSet<VacationInterval>();

        for (VacationInterval item :  pharmacistRepository.getOne(pId).getVacationSchedule()) {
                if(!item.getId().equals(rId)){
                    newVal.add(item);
                }
        }


  
        p.setVacationSchedule(newVal);


        pharmacistRepository.save(p);

        vacationIntervalRepository.delete(vacationIntervalRepository.getOne(rId));

        return true;

    }

    @Override
    public Boolean rejectRequestDermatologist(Long dId, Long rId,String reason) {
            Dermatologist d = dermatologistRepository.getOneById(dId);

            VacationInterval vi = vacationIntervalRepository.getOne(rId);
            String email = d.getEmail();
        try{
            String subject="Response to vacation request \n\n";
            String text="We are informing you that your vacation request from " + vi.getDateStart() + " to " + vi.getDateEnd() + "in pharmacy " + pharmacyRepository.getOne(vi.getPharmacyId()).getName() + " is rejected.\n" + reason;
            emailService.sendNotificaitionAsync(email,subject,text);
        }
        catch(Exception e){
            return false;
        }
        Set<VacationInterval> newVal =new HashSet<VacationInterval>();

        for (VacationInterval item :  d.getVacationSchedule()) {
                if(!item.getId().equals(rId)){
                    newVal.add(item);
                }
        }

  
        d.setVacationSchedule(newVal);

        dermatologistRepository.save(d);
        
        vacationIntervalRepository.delete(vacationIntervalRepository.getOne(rId));

        return true;

        
    }

    public Boolean acceptVacationPharmacist(Long pId,Long rId){
            VacationInterval vi = vacationIntervalRepository.getOne(rId);
            vi.setApproved(true);
            vacationIntervalRepository.save(vi);
        try{
            String subject="Response to vacation request \n\n";
            String text="We are informing you that your vacation request from " + vi.getDateStart() + " to " + vi.getDateEnd() + "in pharmacy " + pharmacyRepository.getOne(vi.getPharmacyId()).getName() + " is accepted.";
            emailService.sendNotificaitionAsync(pharmacistRepository.getOne(pId).getEmail(),subject,text);

            return true;
        }
        catch(Exception e){
            return false;
        }
     }

     public Boolean acceptVacationDermatologist(Long dId,Long rId){
        try{
            VacationInterval vi = vacationIntervalRepository.getOne(rId);
            vi.setApproved(true);
            vacationIntervalRepository.save(vi);

            String subject="Response to vacation request \n\n";
            String text="We are informing you that your vacation request from " + vi.getDateStart() + " to " + vi.getDateEnd() + "in pharmacy " + pharmacyRepository.getOne(vi.getPharmacyId()).getName() + " is accepted.";
            emailService.sendNotificaitionAsync(dermatologistRepository.getOne(dId).getEmail(),subject,text);

            return true;
        }
        catch(Exception e){
            return false;
        }
     }

}
