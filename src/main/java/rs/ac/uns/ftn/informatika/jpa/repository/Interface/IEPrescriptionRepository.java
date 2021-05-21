package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;

public interface IEPrescriptionRepository extends JpaRepository<EPrescription, Long> {

	@Override
	public EPrescription getOne(Long id);
	@Override
	public <S extends EPrescription> S save(S entity);
}
