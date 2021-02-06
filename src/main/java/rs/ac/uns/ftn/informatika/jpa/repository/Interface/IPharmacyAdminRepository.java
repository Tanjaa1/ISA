package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public interface IPharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Long> {

	@Override
	public <S extends PharmacyAdmin> S save(S entity);

	@Override
	List<PharmacyAdmin> findAll();

	@Override
    public PharmacyAdmin getOne(Long id);
}
