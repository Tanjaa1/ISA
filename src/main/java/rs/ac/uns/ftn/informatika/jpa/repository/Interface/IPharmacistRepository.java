package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistRepository extends JpaRepository<Pharmacist, Long> {

	@Override
	public Pharmacist getOne(Long id);

	@Override
	public <S extends Pharmacist> S save(S entity);

	ArrayList<Pharmacist> findAll();

	@Query("SELECT p FROM Pharmacist p,Counseling c WHERE p.Id=c.Pharmacist and (?1 between c.StartTime and c.EndTime)")
	public List<Pharmacist> gPharmacistBySartTime(LocalDateTime start);

	@Query("SELECT p FROM Pharmacist p,Pharmacy ph WHERE p.Pharmacy=ph.Id and ph.Id= ?1")
	public List<Pharmacist> gPharmacistsByPharmacyId(Long id);

	@Query("SELECT distinct ph FROM Pharmacist ph,Counseling c,Patient p WHERE c.Pharmacist=ph.Id and c.Patient=p.Id and p.Id=?1")
    public List<Pharmacist> getPharmacists(Long id);


}
