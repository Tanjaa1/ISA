package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

	@Override
	public Reservation getOne(Long id);
	@Override
	public <S extends Reservation> S save(S entity);
	@Override
	public List<Reservation> findAll();
    
}
