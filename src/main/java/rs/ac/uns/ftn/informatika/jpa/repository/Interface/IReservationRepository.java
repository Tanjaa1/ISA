package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

	@Override
	public Reservation getOne(Long id);
	@Override
	public <S extends Reservation> S save(S entity);
	@Override
	public List<Reservation> findAll();

    @Query("SELECT r FROM Reservation r, Pharmacy p WHERE r.Id=?1 and r.Pharmacy=p.Id and p.Id=?2")
	public Reservation getReservationById(Long id, Long pharmacyId);

	@Query("SELECT r FROM Reservation r, Patient p WHERE r.Patient=p.Id and p.Id=?1")
	public List<Reservation> getReservationsByPatientId(Long id);

	@Query("SELECT r FROM Reservation r WHERE r.Pharmacy =?1 and r.Medicine =?2 and r.IsReceived = false")
	public List<Reservation> getReservationByPharmacyAndMedicine(Pharmacy pharmacy,MedicinePriceAndQuantity medicine);
    
    
}
