package rs.ac.uns.ftn.informatika.jpa.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SystemAdmin")
public class SystemAdmin extends User{

	// @OneToMany(mappedBy = "SystemAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<ComplaintAnswer> ComplaintAnswers = new HashSet<ComplaintAnswer>();

	public SystemAdmin(){}

	public SystemAdmin(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description/*, Set<ComplaintAnswer> complaintAnswers*/) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		///ComplaintAnswers = complaintAnswers;
	}

	// public Set<ComplaintAnswer> getComplaintAnswers() {
	// 	return ComplaintAnswers;
	// }

	// public void setComplaintAnswers(Set<ComplaintAnswer> complaintAnswers) {
	// 	ComplaintAnswers = complaintAnswers;
	// }
	
	public SystemAdmin(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
	}
}
