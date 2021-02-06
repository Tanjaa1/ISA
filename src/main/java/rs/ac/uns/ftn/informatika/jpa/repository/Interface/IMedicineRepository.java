package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
	@Override
    public Medicine getOne(Long id);
	@Override
	public <S extends Medicine> S save(S entity);
}