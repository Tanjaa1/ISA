package rs.ac.uns.ftn.informatika.jpa.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPriceAndQuantityRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IReservationService;
import rs.ac.uns.ftn.informatika.jpa.util.DateCompare;

@Service
public class ResrvationService implements IReservationService{
    
	@Autowired
	private IReservationRepository reservationRepository;

	@Autowired
	private IPriceAndQuantityRepository priceAndQuantityRepository;

    private DateCompare dateCompare=new DateCompare();
	
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	
	@Override
	public ReservationDTO findOne(Long id)
	{
	    Reservation reservation = reservationRepository.getOne(id);
		if(reservation.getPharmacy().getId()!=1)
		{
			if (reservation.getIsReceived() || dateCompare.compareDates(reservation.getExpirationDate()))
				return null;
		}
        return new ReservationDTO(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) throws Exception
	{
		return reservationRepository.save(reservation);
	}
    
	public Reservation updateReservation(Long id) throws Exception 
	{
        Reservation reservation=reservationRepository.getOne(id);
        if(reservation==null)
            throw new Exception("Reservation does not found.");
        reservation.setIsReceived(true);
		changeMedicineQuantity(reservation);
		emailSender(reservation);
		return update(reservation);
	}

	private void changeMedicineQuantity(Reservation reservation)
	{
		Long medicine=reservation.getMedicine().getMedicine().getCode();
		for (MedicinePriceAndQuantity medicinePQ : reservation.getPharmacy().getPricelist()) 
		{
			if(medicinePQ.getMedicine().getCode()==medicine)
			{
				medicinePQ.setQuantity(medicinePQ.getQuantity()-reservation.getMedicine().getQuantity());
				priceAndQuantityRepository.save(medicinePQ);
			}
		}
	}

	private void emailSender(Reservation reservation)
	{
		try {
			String subject="Reservation "+ reservation.getId();
			String text="Dear "+ reservation.getPatient().getFullName()+",\nThank you for your trust!\nReservation taken!";
			emailService.sendNotificaitionAsync(reservation.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}
}
