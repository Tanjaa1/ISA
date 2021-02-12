package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;

public interface IPenaltyRepository extends JpaRepository<Penaltys, Long> {
    
    @Override
	public <S extends Penaltys> S save(S entity);
}
