package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;

public interface IComplaintAnswerRepository extends JpaRepository<ComplaintAnswer, Long> {

	@Override
	public ComplaintAnswer getOne(Long id);
	@Override
	public <S extends ComplaintAnswer> S save(S entity);
  
  	ArrayList<ComplaintAnswer> findAll();
}