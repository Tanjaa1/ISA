package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyRepository extends JpaRepository<Pharmacy, Long> {
 
    @Override
	public List<Pharmacy> findAll();

    @Override
	public Pharmacy getOne(Long id);

    @Override
	public <S extends Pharmacy> S save(S entity);

    @Query("SELECT u FROM Pharmacy u WHERE u.Name like ?1")
    public Pharmacy getByName(String name);
    
    @Query("SELECT distinct ph FROM Pharmacy ph,Counseling c,Patient p WHERE c.Pharmacy=ph.Id and c.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromCounseling(Long id);

    @Query("SELECT distinct ph FROM Pharmacy ph,Examination e,Patient p WHERE e.Pharmacy=ph.Id and e.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromExamination(Long id);

    @Query("SELECT distinct ph FROM Pharmacy ph,Reservation r,Patient p WHERE r.Pharmacy=ph.Id and r.Patient=p.Id and p.Id=?1")
    public List<Pharmacy> getPharmaciesFromReservation(Long id);
}
