package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;

public interface IMedicinePriceAndQuantity extends JpaRepository<MedicinePriceAndQuantity, Long> {
    @Override
	public <S extends MedicinePriceAndQuantity> S save(S entity);
}
