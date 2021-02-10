package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

public interface IVacationIntervalService {
    VacationInterval add(VacationInterval vacationInterval);
    VacationInterval addPharmacistVacation(VacationInterval vacationInterval,Long id) throws Exception;
    VacationInterval addDermatologististVacation(VacationInterval vacationInterval,Long id) throws Exception;
}
