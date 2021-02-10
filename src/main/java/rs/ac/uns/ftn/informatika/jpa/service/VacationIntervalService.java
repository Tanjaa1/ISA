package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
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
    private IPharmacistRepository pharmacistRepository;

    public VacationInterval add(VacationInterval vacationInterval)
    {
        VacationInterval v=new VacationInterval();
        v.setDateStart(vacationInterval.getDateStart());
        v.setDateEnd(vacationInterval.getDateEnd());
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
        return v;
    }
}
