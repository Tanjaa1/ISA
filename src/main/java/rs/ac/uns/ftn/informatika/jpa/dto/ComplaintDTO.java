package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Complaint;


public class ComplaintDTO {
	private Long Id;
	private String Text;
	private String Subject;
	private PatientDTO Patient;
    private Boolean IsAnswered;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public PatientDTO getPatient() {
        return Patient;
    }

    public void setPatient(PatientDTO patient) {
        Patient = patient;
    }

    

    public ComplaintDTO(){}

    public ComplaintDTO(Complaint complaint){
        Id = complaint.getId();
        Text = complaint.getText();
        Subject = complaint.getSubject();
        Patient = new PatientDTO(complaint.getPatient());
        IsAnswered=complaint.getIsAnswered();
    }

    public ComplaintDTO toDTO(Complaint complaint){
        return new ComplaintDTO(complaint);
    }

    public Boolean getIsAnswered() {
        return IsAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        IsAnswered = isAnswered;
    }
}
