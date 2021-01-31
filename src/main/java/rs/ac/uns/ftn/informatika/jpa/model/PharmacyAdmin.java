package rs.ac.uns.ftn.informatika.jpa.model;

public class PharmacyAdmin extends User{
	private Pharmacy Pharmacy;

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}

	public PharmacyAdmin(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description,
			rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		Pharmacy = pharmacy;
	}
}
