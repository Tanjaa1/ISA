package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintAnswerDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintAnswerRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IComplaintAnswerService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IComplaintService;

@Service
public class ComplaintAnswerService implements IComplaintAnswerService {

    @Autowired
	private IComplaintAnswerRepository complaintAnswerRepository;

    @Autowired
	private IComplaintService complaintService;



	@Autowired
	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

    @Autowired
	private PatientService patientService;

    @Override
    public ComplaintAnswer findOne(Long id) {
        return complaintAnswerRepository.findById(id).get();
   }

    @Override
    public ComplaintAnswer update(ComplaintAnswer complaint) throws Exception {
        
        ComplaintAnswer complaint1 = findOne(complaint.getId());
        if (complaint1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
            complaint1.setId(complaint.getId());
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
        PatientDTO patient=patientService.findByIdComplaints(complaint.getComplaint().getId());
       
        Complaint complaint2=complaintService.findOne(complaint.getComplaint().getId());
        complaint2.setIsAnswered(true);
        complaintService.update(complaint2);

        ComplaintAnswer ca=new ComplaintAnswer();
        ca.setComplaint(complaint2);
        ca.setId(complaint.getId());
        ca.setText(complaint.getText());


        complaintAnswerRepository.save(ca);
        emailSender(patient);
		return new ResponseEntity<>( HttpStatus.CREATED);  
    }

    public ComplaintAnswerDTO gComplaintAnswerByComplaintId(Long id){
        List<ComplaintAnswerDTO> complaintAnswers=findAll();
        ComplaintAnswerDTO resuComplaintAnswerDTO=new ComplaintAnswerDTO();
        for (ComplaintAnswerDTO complaintAnswerDTO : complaintAnswers) {
            if(complaintAnswerDTO.getComplaint().getId()==id)
                 resuComplaintAnswerDTO=complaintAnswerDTO;
         }
         return resuComplaintAnswerDTO;    
    }
    private void emailSender(PatientDTO patient)
	{   Long cId=0L;
        List<ComplaintDTO> complaints=complaintService.getAllComplaints();
        if(!complaints.isEmpty()){
            for (ComplaintDTO complaintDTO : complaints) {
                if(complaintDTO.getPatient().getId()==patient.getId())  
                    cId=complaintDTO.getId();
            }
        }


        ComplaintAnswerDTO complaintAnswer=gComplaintAnswerByComplaintId(cId);


		try {
			String subject="Patient "+ patient.getName()+patient.getSurname();
			String text="Dear "+ patient.getName()+patient.getSurname()+",\n Our response on your complaint: \n " + complaintAnswer.getText();
			emailService.sendNotificaitionAsync(patient.getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}



	

}
