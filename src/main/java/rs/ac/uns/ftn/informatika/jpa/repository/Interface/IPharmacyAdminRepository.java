package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public interface IPharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Long> {

	@Override
	public <S extends PharmacyAdmin> S save(S entity);

	@Override
	List<PharmacyAdmin> findAll();

	@Override
    public PharmacyAdmin getOne(Long id);
	
	@Query("SELECT p FROM PharmacyAdmin p WHERE p.Pharmacy like ?1")
	public PharmacyAdmin findPharmacyAdminByPharmacyName(String name);

	@Query("SELECT p FROM PharmacyAdmin p")
	public List<PharmacyAdmin> getAll();
}
