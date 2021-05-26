package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

public interface IVacationIntervalRepository extends JpaRepository<VacationInterval, Long> {
    @Override
	public <S extends VacationInterval> S save(S entity);

    @Query("SELECT v FROM VacationInterval v WHERE v.PharmacyId = ?1 and v.DateStart >= CURRENT_DATE ")
    public List<VacationInterval> getByPharmacyId(Long pID);
}
