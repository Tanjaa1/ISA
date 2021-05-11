package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintAnswerDTO;

@Entity
@Table(name="ComplaintAnswer")
public class ComplaintAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Complaint_id", referencedColumnName = "id")
	private Complaint Complaint;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	

	public ComplaintAnswer(){}

	public ComplaintAnswer(Long id,Complaint complaint, String text) {
		super();
		this.id = id;
		Complaint = complaint;
		Text = text;
	}
	public ComplaintAnswer(Complaint complaint, String text) {
		super();
		Complaint = complaint;
		Text = text;
	}

	public ComplaintAnswer(ComplaintAnswerDTO complaintAnswerDTO){
		id=complaintAnswerDTO.getId();
		Text=complaintAnswerDTO.getText();
		Complaint=new Complaint(complaintAnswerDTO.getComplaint());
		

	}
	
	
}
