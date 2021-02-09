package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.controller.ComplaintController;
import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;

@Entity
@Table(name="Complaint")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;

	@Column(name="isAnswered", unique=false, nullable=false)
	private Boolean isAnswered;
	
	@Column(name="Subject", unique=false, nullable=true)
	private String Subject;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient Patient;


	
	public Complaint(){}

	public Complaint(Long id, String text, String subject,Patient patient,Boolean isAnswered) {
		super();
		this.id = id;
		Text = text;
		Subject = subject;
		Patient = patient;
		isAnswered=isAnswered;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	
	public Complaint(ComplaintDTO complaintDTO){
		id=complaintDTO.getId();
		Text=complaintDTO.getText();
		Subject=complaintDTO.getSubject();
		Patient=new Patient(complaintDTO.getPatient());
		isAnswered=complaintDTO.getIsAnswered();
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}
	
	
}
