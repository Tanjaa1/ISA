package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;

@Entity
@Table(name="PharmacyAdmin")
public class PharmacyAdmin extends User{
	
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

		public PharmacyAdmin(PharmacyAdminDTO pa) {
		super(pa.getId(), pa.getEmail(), pa.getPassword(), pa.getName(), pa.getSurname(), pa.getAddress(), pa.getCity(), pa.getCity(), pa.getPhoneNumber(), pa.getDescription(), pa.getEmailComfirmed(),
		pa.getFirstTimeLogin(), pa.getUsername());
		Pharmacy = pa.getPharmacy().getName();
		
	}
}
