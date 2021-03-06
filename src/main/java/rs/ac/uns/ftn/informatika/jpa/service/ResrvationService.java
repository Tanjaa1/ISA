package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPriceAndQuantityRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IReservationService;
import rs.ac.uns.ftn.informatika.jpa.util.DateCompare;

@Service
@Transactional(readOnly = true)
public class ResrvationService implements IReservationService{
    
	@Autowired
	private IReservationRepository reservationRepository;

	@Autowired
	private IPriceAndQuantityRepository priceAndQuantityRepository;
    
    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IPharmacyRepository pharmacyRepository;
	
    @Autowired
    private IMedicineRepository medicineRepository;
	@Autowired
    private PatientService patientService;
	@Autowired
    private MedicineService medicineService;


    private DateCompare dateCompare=new DateCompare();
	
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	
	@Override
	public ReservationDTO getReservationById(Long id, Long pharmacyId)
	{	
		Reservation reservation = reservationRepository.getReservationById(id,pharmacyId);

		if(reservation!=null)
		reservation.getMedicine().setPrice(medicineService.Discount(reservation.getMedicine().getPrice(), reservation.getPatient().getId()));

		if (reservation!=null && !reservation.getIsReceived() && !dateCompare.compareDates(reservation.getExpirationDate()) && !reservation.getIsCanceled())
			return new ReservationDTO(reservation);
		else
			return null;
	}

	
	@Override
	public Reservation update(Reservation reservation) throws Exception
	{
		return reservationRepository.save(reservation);
	}
    
	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
	public Reservation updateReservation(Long id) throws Exception 
	{
        Reservation reservation=reservationRepository.getOne(id);
        if(reservation==null)
            throw new Exception("Reservation does not found.");
        reservation.setIsReceived(true);
		
		Patient patient =reservation.getPatient();
		Medicine medicine=medicineRepository.findById(reservation.getMedicine().getMedicine().getId()).get();
		patient.setPoints(patient.getPoints()+medicine.getPoints());
		patientService.update(patient);
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

	public ReservationDTO makeReservation(Reservation reservation) {
		Reservation r = new Reservation();
		r.setExpirationDate(reservation.getExpirationDate());
		r.setIsCanceled(reservation.getIsCanceled());
		r.setIsReceived(reservation.getIsReceived());
		r.setPharmacy(pharmacyRepository.getOne(reservation.getPharmacy().getId()));
        r.setMedicine(priceAndQuantityRepository.getOne(reservation.getMedicine().getId()));
        r.setPatient(patientRepository.getOne(reservation.getPatient().getId()));
        ReservationDTO councelingDTO= new ReservationDTO(reservationRepository.save(r));
        emailSender3(r);
        return councelingDTO;
	}

	@Transactional(readOnly=false)
	public ReservationDTO makeNewReservation(Reservation reservation) {

        Pharmacy pharmacy = pharmacyRepository.getByName(reservation.getPharmacy().getName());

        Set<MedicinePriceAndQuantity> pricelist = pharmacy.getPricelist();
        for (MedicinePriceAndQuantity medicinePriceAndQuantity : pricelist) {
                if((long)medicinePriceAndQuantity.getMedicine().getId() == (long) reservation.getMedicine().getMedicine().getId()){
					if(medicinePriceAndQuantity.getQuantity() == 0){
						return null;
					}
                    medicinePriceAndQuantity.setQuantity(medicinePriceAndQuantity.getQuantity() - 1);
                }
        }
		
		pharmacy.setPricelist(pricelist);

		try {
			pharmacyRepository.save(pharmacy);
		} catch (Exception e) {

		}

		Reservation r = new Reservation();
		r.setExpirationDate(reservation.getExpirationDate());
		r.setIsCanceled(false);
		r.setIsReceived(false);
		r.setPharmacy(pharmacyRepository.getOne(reservation.getPharmacy().getId()));
        r.setMedicine(priceAndQuantityRepository.getOne(reservation.getMedicine().getId()));
        //c.setPatient(patientRepository.getOne(counseling.getPatient().getId()));
        Long id = (long) 88;
        r.setPatient(patientRepository.getOne(id));
        ReservationDTO councelingDTO= new ReservationDTO(reservationRepository.save(r));
        emailSender3(r);
        return councelingDTO;
	}

	private void emailSender3(Reservation reservation)
	{
		LocalDate date= new java.sql.Date( reservation.getExpirationDate().getTime() ) .toLocalDate();
		try {
			String subject="Pharmacy "+ reservation.getPharmacy().getName()+"\n\n";
			String text="Dear "+ reservation.getPatient().getFullName()+ ",\n\n"+ "Your made successfull reservation of medicine "+ 
			reservation.getMedicine().getMedicine().getName() +
             "\nExpiration date: " + date + ",\n\nThank you for your trust!\n\n Pharmacy "+reservation.getPharmacy().getName();
			emailService.sendNotificaitionAsync(reservation.getPatient().getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}
}
