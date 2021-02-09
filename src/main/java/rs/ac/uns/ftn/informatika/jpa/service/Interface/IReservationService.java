package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IReservationService {
    
	public ReservationDTO getReservationById(Long id,Long pharmacyId) throws Exception;
	Reservation update(Reservation reservation) throws Exception;
	public List<ReservationDTO> getAllByPatientId(Long id);
}
