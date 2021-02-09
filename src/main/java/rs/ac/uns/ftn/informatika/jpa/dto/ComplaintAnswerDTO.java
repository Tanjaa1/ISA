package rs.ac.uns.ftn.informatika.jpa.dto;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;


public class ComplaintAnswerDTO {
    
	private Long Id;
    private ComplaintDTO Complaint;
	private String Text;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public ComplaintDTO getComplaint() {
        return Complaint;
    }

    public void setComplaint(ComplaintDTO complaint) {
        Complaint = complaint;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    
    public ComplaintAnswerDTO(Long id, ComplaintDTO complaint, String text) {
        Id = id;
        Complaint = complaint;
        Text = text;
        
    }

    public ComplaintAnswerDTO(){}

    public ComplaintAnswerDTO(ComplaintAnswer complaint){
        Id = complaint.getId();
        Text = complaint.getText();
        Complaint = new ComplaintDTO(complaint.getComplaint());
    }

    public ComplaintAnswerDTO toDTO(ComplaintAnswer complaint){
        return new ComplaintAnswerDTO(complaint);
    }

    public ComplaintAnswerDTO( ComplaintDTO complaint, String text) {
        Complaint = complaint;
        Text = text;
    }
}
