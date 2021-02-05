package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PharmacyAdmin")
public class PharmacyAdmin extends User{
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}

	public PharmacyAdmin(){}

	public PharmacyAdmin(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description,
			rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		Pharmacy = pharmacy;
	}
}
