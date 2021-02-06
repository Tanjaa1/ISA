package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;

public interface ISystemAdminRepository extends JpaRepository<SystemAdmin, Long> {

	@Override
	public <S extends SystemAdmin> S save(S entity);

	@Override
	List<SystemAdmin> findAll();

	@Override
    public SystemAdmin getOne(Long id);
}
