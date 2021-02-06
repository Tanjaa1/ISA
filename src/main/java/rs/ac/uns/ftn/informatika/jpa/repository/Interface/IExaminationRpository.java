package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;


public interface IExaminationRpository extends JpaRepository<Examination, Long> {
	@Override
	public List<Examination> findAll();
	@Override
	public Examination getOne(Long id);
	@Override
	public <S extends Examination> S save(S entity);
}
