package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyRepository extends JpaRepository<Pharmacy, Long> {
 
    @Override
	public List<Pharmacy> findAll();

    @Override
	public Pharmacy getOne(Long id);

}
