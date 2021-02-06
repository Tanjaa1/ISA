package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PharmacyAdmin")
public class PharmacyAdmin extends User{
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name="Pharmacy", unique=false, nullable=true)
	private String Pharmacy;

	public String getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		Pharmacy = pharmacy;
	}

	public PharmacyAdmin(){}

	public PharmacyAdmin(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description,String pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		Pharmacy = pharmacy;
	}
	
	public PharmacyAdmin(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin, String username, String pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		Pharmacy = pharmacy;
	}
}
