package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IPharmacyRepository extends JpaRepository<Pharmacy, Long> {
 
    @Override
	public List<Pharmacy> findAll();

    @Override
	public Pharmacy getOne(Long id);

    @Override
	public <S extends Pharmacy> S save(S entity);

    @Query("SELECT u FROM Pharmacy u WHERE u.Name like ?1")
    public Pharmacy getByName(String name);
    
    @Query("SELECT p FROM Pharmacy p WHERE p.Id = ?1")
    public Pharmacy getById(Long Id);

    @Query("SELECT distinct ph FROM Pharmacy ph,Counseling c,Patient p WHERE c.Pharmacy=ph.Id and c.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromCounseling(Long id);

    @Query("SELECT distinct ph FROM Pharmacy ph,Examination e,Patient p WHERE e.Pharmacy=ph.Id and e.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromExamination(Long id);

    @Query("SELECT distinct ph FROM Pharmacy ph,Reservation r,Patient p WHERE r.Pharmacy=ph.Id and r.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromReservation(Long id);

    @Query("SELECT r FROM Pharmacy ph , Reservation r ,MedicinePriceAndQuantity mpq , Medicine m  WHERE r.Pharmacy=ph.Id AND ph.Id=?1 AND r.Medicine = mpq.Id AND mpq.Medicine = m.Id AND m.Id = ?2  AND r.IsReceived = true")
    public List<Reservation> getMedicineConsumptionReportMonth(Long pharmacyId , Long medicineId);

    @Query("SELECT ex FROM Examination ex , Pharmacy ph WHERE ex.Pharmacy=ph.Id AND ph.Id=?1 AND ex.isDone = true")
    public List<Examination> getFinishedExaminations(Long pharmacyId);

    @Query("SELECT r FROM Pharmacy ph , Reservation r  WHERE r.Pharmacy=ph.Id AND ph.Id=?1 AND  r.IsReceived = true")
    public List<Reservation> getConsumedMeds(Long pharmacyId);

    @Query("SELECT c FROM Pharmacy ph , Counseling c  WHERE c.Pharmacy=ph.Id AND ph.Id=?1 AND  c.isDone = true")
    public List<Counseling> getCounselngsFinished(Long pharmacyId);
}
