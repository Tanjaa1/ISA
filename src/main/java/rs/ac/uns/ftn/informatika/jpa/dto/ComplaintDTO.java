package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;


public class ComplaintDTO {
	private Long Id;
	private String Text;
	private String Subject;
	private Patient Patient;

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

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public ComplaintDTO(){}

    public ComplaintDTO(Complaint complaint){
        Id = complaint.getId();
        Text = complaint.getText();
        Subject = complaint.getSubject();
        Patient = complaint.getPatient();
    }

    public ComplaintDTO toDTO(Complaint complaint){
        return new ComplaintDTO(complaint);
    }
}
