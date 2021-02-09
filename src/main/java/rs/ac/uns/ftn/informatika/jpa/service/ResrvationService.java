package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
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
	public ReservationDTO getReservationById(Long id, Long pharmacyId)
	{
	    Reservation reservation = reservationRepository.getReservationById(id,pharmacyId);
		if (reservation!=null && !reservation.getIsReceived() && !dateCompare.compareDates(reservation.getExpirationDate()))
			return new ReservationDTO(reservation);
		else
			return null;
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
		Long medicine=reservation.getMedicine().getMedicine().getId();
		for (MedicinePriceAndQuantity medicinePQ : reservation.getPharmacy().getPricelist()) 
		{
			if(medicinePQ.getMedicine().getId()==medicine)
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
			String text="Dear "+ reservation.getPatient().getFullName()+
						",\n\nThank you for your trust!\nReservation taken!\n\n"+reservation.getPharmacy().getName();
			emailService.sendNotificaitionAsync(reservation.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	public List<ReservationDTO> getAllByPatientId(Long id){
		List<ReservationDTO> patientReservations = new ArrayList<ReservationDTO>();
		List<Reservation> reservations = reservationRepository.findAll();
		for (Reservation reservation : reservations) {
			if(id == reservation.getPatient().getId() && !reservation.getIsReceived()){
				patientReservations.add( new ReservationDTO(reservation));
			}
		}
		return patientReservations;
	}

	public List<ReservationDTO> getAllReceivedByPatientId(Long id) {
		List<ReservationDTO> patientReservations = new ArrayList<ReservationDTO>();
		List<Reservation> reservations = reservationRepository.findAll();
		for (Reservation reservation : reservations) {
			if(id == reservation.getPatient().getId() && reservation.getIsReceived()){
				patientReservations.add( new ReservationDTO(reservation));
			}
		}
		return patientReservations;
	}

	public Set<ReservationDTO> getAllReceivedByPatientIdSet(Long id) {
		Set<ReservationDTO> patientReservations = new HashSet();

		List<Reservation> reservations = reservationRepository.findAll();
		for (Reservation reservation : reservations) {
			if(id == reservation.getPatient().getId() && reservation.getIsReceived()){
				patientReservations.add( new ReservationDTO(reservation));
			}
		}
		return patientReservations;
	}

	

	public Set<PharmacyDTO> getPharmaciesOfReceivedReservationByPatientId(Long id) {
		Set<PharmacyDTO> resultPharmacies=new HashSet();
		Set <ReservationDTO> reservationDTOs =getAllReceivedByPatientIdSet(id);
		for (ReservationDTO reservationDTO : reservationDTOs) {
			if(id==reservationDTO.getPatient().getId()){
				resultPharmacies.add(reservationDTO.getPharmacy());
			}
		}
		return resultPharmacies;
	}

	public Reservation updateReservationIsCancel(Reservation reservation) {
		Reservation r = reservationRepository.getOne(reservation.getId());
		if(!dateCompare.compareDates(reservation.getExpirationDate())){
        	r.setIsCanceled(true);
		}
        return reservationRepository.save(r);
	}
}
