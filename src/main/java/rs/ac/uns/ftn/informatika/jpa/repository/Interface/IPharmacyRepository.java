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
}
