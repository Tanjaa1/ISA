package rs.ac.uns.ftn.informatika.jpa.repository.Interface;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;

public interface IPriceAndQuantityRepository extends JpaRepository<MedicinePriceAndQuantity, Long> {
    
    @Override
	public List<MedicinePriceAndQuantity> findAll();
	@Override
	public <S extends MedicinePriceAndQuantity> S save(S entity);
}
