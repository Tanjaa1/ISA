package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

public interface IVacationIntervalRepository extends JpaRepository<VacationInterval, Long> {
    @Override
	public <S extends VacationInterval> S save(S entity);
}
