package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

public class Supplier extends User {
	private ArrayList<MedicineQuantity> Medicines;

	public Supplier(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, ArrayList<MedicineQuantity> medicines) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		Medicines = medicines;
	}

	public ArrayList<MedicineQuantity> getMedicines() {
		return Medicines;
	}

	public void setMedicines(ArrayList<MedicineQuantity> medicines) {
		Medicines = medicines;
	}
}
