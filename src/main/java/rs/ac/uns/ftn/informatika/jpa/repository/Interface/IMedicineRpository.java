package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineRpository extends JpaRepository<Medicine, Long> {
	@Override
	public List<Medicine> findAll();   
}
