package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Supplier;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    @Override
	public <S extends Supplier> S save(S entity);
    @Override
	public Supplier getOne(Long id);
}
