package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPriceAndQuantityRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IReservationService;
import rs.ac.uns.ftn.informatika.jpa.util.DateCompare;

@Service
public class ResrvationService implements IReservationService{
    
	@Autowired
	private IReservationRepository reservationRepository;

	@Autowired
	private IPriceAndQuantityRepository priceAndQuantityRepository;

    private DateCompare dateCompare=new DateCompare();

	@Override
	public ReservationDTO findOne(Long id){
	    Reservation reservation = reservationRepository.getOne(id);
        if (reservation.getIsReceived() || dateCompare.compareDates(reservation.getExpirationDate()))
            return null;
        return new ReservationDTO(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) throws Exception{
		return reservationRepository.save(reservation);
	}
    
	public Reservation updateReservation(Long id) throws Exception {
        Reservation reservation=reservationRepository.getOne(id);
        if(reservation==null)
            throw new Exception("Reservation does not found.");
        reservation.setIsReceived(true);
		changeMedicineQuantity(reservation);
		return update(reservation);
	}

	private void changeMedicineQuantity(Reservation reservation){
		Long medicine=reservation.getMedicine().getMedicine().getCode();
		for (MedicinePriceAndQuantity medicinePQ : reservation.getPharmacy().getPricelist()) {
			if(medicinePQ.getMedicine().getCode()==medicine){
				medicinePQ.setQuantity(medicinePQ.getQuantity()-reservation.getMedicine().getQuantity());
				priceAndQuantityRepository.save(medicinePQ);
			}
		}
	}
}
