package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IReservationService {
    
	public ReservationDTO findOne(Long id) throws Exception;
	Reservation update(Reservation reservation) throws Exception;
}
