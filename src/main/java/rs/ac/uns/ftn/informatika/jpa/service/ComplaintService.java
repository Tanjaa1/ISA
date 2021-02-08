package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<ComplaintDTO> findAll() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints = complaintRepository.findAll();
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints)
            returnValue.add(complaintDTO.toDTO(complaint));
        return returnValue;
    }

    @Override
    public ResponseEntity<Complaint> save(Complaint complaint) throws Exception {
        complaintRepository.save(complaint);
		return new ResponseEntity<>( HttpStatus.CREATED);  
    }

	

}
