package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;


import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;

public interface IComplaintService{

public Complaint findOne(Long id);
Complaint update(Complaint complaint) throws Exception;
  List<ComplaintDTO> getAllComplaintsAnswered();
  List<ComplaintDTO> getAllComplaintsNotAnswered();
  public List<ComplaintDTO> getAllComplaints();

  public ComplaintDTO save(Complaint dermatologist) throws Exception;

}