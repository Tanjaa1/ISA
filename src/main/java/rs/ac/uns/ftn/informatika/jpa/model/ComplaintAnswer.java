package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SystemAdmin SystemAdmin;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public SystemAdmin getSystemAdmin() {
		return SystemAdmin;
	}
	public void setSystemAdmin(SystemAdmin systemAdmin) {
		SystemAdmin = systemAdmin;
	}

	public ComplaintAnswer(){}

	public ComplaintAnswer(long id, rs.ac.uns.ftn.informatika.jpa.model.Complaint complaint, String text,
			rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin systemAdmin) {
		super();
		this.id = id;
		Complaint = complaint;
		Text = text;
		SystemAdmin = systemAdmin;
	}
	
	
}
