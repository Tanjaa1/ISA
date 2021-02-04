package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	
}
