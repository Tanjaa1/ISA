package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintAnswerDTO;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintAnswerRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IComplaintAnswerService;

@Service
public class ComplaintAnswerService implements IComplaintAnswerService {

    @Autowired
	private IComplaintAnswerRepository complaintAnswerRepository;


    @Override
    public ComplaintAnswer findOne(Long id) {
        return complaintAnswerRepository.getOne(id);
   }

    @Override
    public ComplaintAnswer update(ComplaintAnswer complaint) throws Exception {
        
        ComplaintAnswer complaint1 = findOne(complaint.getId());
        if (complaint1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
            complaint1.setId(complaint.getId());
            complaint1.setSystemAdmin(complaint.getSystemAdmin());
            complaint1.setText(complaint.getText());
            complaint1.setComplaint(complaint.getComplaint());
        return complaintAnswerRepository.save(complaint1);
    }

    @Override
    public List<ComplaintAnswerDTO> findAll() {
        ComplaintAnswerDTO complaintDTO = new ComplaintAnswerDTO();
        List<ComplaintAnswer> complaints = complaintAnswerRepository.findAll();
        List<ComplaintAnswerDTO> returnValue = new ArrayList<ComplaintAnswerDTO>();
        for (ComplaintAnswer complaint : complaints)
            returnValue.add(complaintDTO.toDTO(complaint));
        return returnValue;
    }

    @Override
    public ResponseEntity<ComplaintAnswer> save(ComplaintAnswer complaint) throws Exception {
        complaintAnswerRepository.save(complaint);
		return new ResponseEntity<>( HttpStatus.CREATED);  
    }

	

}
