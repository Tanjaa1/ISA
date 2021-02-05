package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;

public interface ICounselingRpository extends JpaRepository<Counseling, Long> {
    @Override
	public List<Counseling> findAll();
}
