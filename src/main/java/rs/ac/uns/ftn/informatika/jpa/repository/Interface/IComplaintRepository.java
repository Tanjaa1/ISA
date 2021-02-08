package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Complaint;

public interface IComplaintRepository  extends JpaRepository<Complaint, Long>{

	@Override
	public Complaint getOne(Long id);
	@Override
	public <S extends Complaint> S save(S entity);
  
  	ArrayList<Complaint> findAll();
}