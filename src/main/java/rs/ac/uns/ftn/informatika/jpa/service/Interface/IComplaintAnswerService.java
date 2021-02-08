package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintAnswerDTO;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;

public interface IComplaintAnswerService {

    public ComplaintAnswer findOne(Long id);
    ComplaintAnswer update(ComplaintAnswer complaint) throws Exception;
      List<ComplaintAnswerDTO> findAll();
      public ResponseEntity<ComplaintAnswer> save(ComplaintAnswer dermatologist) throws Exception;
    
    }