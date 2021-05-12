package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

public interface IWorkTimeRepository extends JpaRepository<WorkingTime, Long> {
    @Override
	public <S extends WorkingTime> S save(S entity);
}
