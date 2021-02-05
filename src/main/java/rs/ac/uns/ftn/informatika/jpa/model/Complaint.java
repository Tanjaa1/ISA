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

@Entity
@Table(name="Complaint")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;
	
	@Column(name="Subject", unique=false, nullable=true)
	private String Subject;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient Patient;
	
	public Complaint(){}

	public Complaint(long id, String text, String subject, rs.ac.uns.ftn.informatika.jpa.model.Patient patient) {
		super();
		this.id = id;
		Text = text;
		Subject = subject;
		Patient = patient;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	
}
