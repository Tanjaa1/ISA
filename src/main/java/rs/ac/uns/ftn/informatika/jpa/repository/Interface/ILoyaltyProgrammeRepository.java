package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;

public interface ILoyaltyProgrammeRepository extends JpaRepository<LoyaltyProgramme, Long> {
    @Override
	public <S extends LoyaltyProgramme> S save(S entity);
}
