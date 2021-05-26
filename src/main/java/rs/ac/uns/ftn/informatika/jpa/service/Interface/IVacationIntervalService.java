package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.VacationIntervalDTO;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

public interface IVacationIntervalService {
    VacationInterval add(VacationInterval vacationInterval);
    VacationInterval addPharmacistVacation(VacationInterval vacationInterval,Long id) throws Exception;
    VacationInterval addDermatologististVacation(VacationInterval vacationInterval,Long id) throws Exception;
    public List<VacationIntervalDTO> getByPharmacyId(Long pId);
    Boolean rejectRequestPharmacist(Long pId,Long rId,String reason);
    Boolean rejectRequestDermatologist(Long dId,Long rId,String reason);
    public Boolean acceptVacationPharmacist(Long pId,Long rId);
    public Boolean acceptVacationDermatologist(Long pId,Long rId);

}
