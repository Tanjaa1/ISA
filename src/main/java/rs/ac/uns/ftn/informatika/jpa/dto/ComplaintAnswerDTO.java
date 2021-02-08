package rs.ac.uns.ftn.informatika.jpa.dto;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;


public class ComplaintAnswerDTO {
    
	private Long Id;
    private Complaint Complaint;
	private String Text;
    private SystemAdmin SystemAdmin;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Complaint getComplaint() {
        return Complaint;
    }

    public void setComplaint(Complaint complaint) {
        Complaint = complaint;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public SystemAdmin getSystemAdmin() {
        return SystemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        SystemAdmin = systemAdmin;
    }

    public ComplaintAnswerDTO(Long id, rs.ac.uns.ftn.informatika.jpa.model.Complaint complaint, String text,
            rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin systemAdmin) {
        Id = id;
        Complaint = complaint;
        Text = text;
        SystemAdmin = systemAdmin;
    }

    public ComplaintAnswerDTO(){}

    public ComplaintAnswerDTO(ComplaintAnswer complaint){
        Id = complaint.getId();
        Text = complaint.getText();
        SystemAdmin = complaint.getSystemAdmin();
        Complaint = complaint.getComplaint();
    }

    public ComplaintAnswerDTO toDTO(ComplaintAnswer complaint){
        return new ComplaintAnswerDTO(complaint);
    }
}
