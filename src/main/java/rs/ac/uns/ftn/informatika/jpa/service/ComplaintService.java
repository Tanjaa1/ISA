package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

    @Autowired
	private IComplaintRepository complaintRepository;


    @Override
    public Complaint findOne(Long id) {
        return complaintRepository.getOne(id);
   }

    @Override
    public Complaint update(Complaint complaint) throws Exception {
        
        Complaint complaint1 = findOne(complaint.getId());
        if (complaint1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
            complaint1.setId(complaint.getId());
            complaint1.setPatient(complaint.getPatient());
            complaint1.setText(complaint.getText());
            complaint1.setSubject(complaint.getSubject());
        return complaintRepository.save(complaint1);
    }

    @Override
    public List<ComplaintDTO> getAllComplaintsAnswered() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<Complaint> complaints2=new ArrayList<>();
        for (Complaint complaint : complaints) {
            if(complaint.getIsAnswered())
            complaints2.add(complaint);
        }
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints2)
            returnValue.add(complaintDTO.toDTO(complaint));
        if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

    @Override
    public List<ComplaintDTO> getAllComplaintsNotAnswered() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<Complaint> complaints2=new ArrayList<>();
        for (Complaint complaint : complaints) {
            if(!complaint.getIsAnswered())
            complaints2.add(complaint);
        }
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints2)
            returnValue.add(complaintDTO.toDTO(complaint));
            if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

    @Override
    public ResponseEntity<Complaint> save(Complaint complaint) throws Exception {
        complaintRepository.save(complaint);
		return new ResponseEntity<>( HttpStatus.CREATED);  
    }

	public ComplaintDTO getById(Long id) {
        ComplaintDTO complaintDTO=new ComplaintDTO(complaintRepository.getOne(id));
        return complaintDTO;
    }

	public List<ComplaintDTO> getAllComplaints() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints)
            returnValue.add(complaintDTO.toDTO(complaint));
        if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

}
