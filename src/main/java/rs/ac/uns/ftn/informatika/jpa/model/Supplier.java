package rs.ac.uns.ftn.informatika.jpa.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier extends User {
	
	
	 @OneToMany(mappedBy = "Supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private Set<MedicineQuantity> Medicines = new HashSet<MedicineQuantity>();

	public Supplier(){}

	public Supplier(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		//Medicines = medicines;
	}
	public Supplier(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Set<MedicineQuantity> medicines) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description);
		Medicines = medicines;
	}
	public Supplier(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
	}
	 public Set<MedicineQuantity> getMedicines() {
	 	return Medicines;
	 }

	 public void setMedicines(Set<MedicineQuantity> medicines) {
	 	Medicines = medicines;
	 }
	
}
