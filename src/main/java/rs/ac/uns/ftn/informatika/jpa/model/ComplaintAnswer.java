package rs.ac.uns.ftn.informatika.jpa.model;

public class ComplaintAnswer {
	private long id;
	private Complaint Complaint;
	private String Text;
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
	public ComplaintAnswer(long id, rs.ac.uns.ftn.informatika.jpa.model.Complaint complaint, String text,
			rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin systemAdmin) {
		super();
		this.id = id;
		Complaint = complaint;
		Text = text;
		SystemAdmin = systemAdmin;
	}
	
	
}
