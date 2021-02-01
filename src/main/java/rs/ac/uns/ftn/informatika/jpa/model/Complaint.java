package rs.ac.uns.ftn.informatika.jpa.model;

public class Complaint {
	private long id;
	private String Text;
	private String Subject;
	private Patient Patient;
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
