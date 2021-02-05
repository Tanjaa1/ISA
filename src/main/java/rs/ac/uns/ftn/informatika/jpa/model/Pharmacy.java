package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pharmacy")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Name", unique=false, nullable=true)
	private String Name;
	
	@Column(name="Address", unique=false, nullable=true)
	private String Address;
	
	@Column(name="Marks", unique=false, nullable=true)
	@ElementCollection
	private Set<Integer> Marks = new HashSet<Integer>();
	
	@OneToMany(mappedBy = "Pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MedicinePriceAndQuantity> Pricelist = new HashSet<MedicinePriceAndQuantity>();
	
	@ManyToMany
	@JoinTable(name = "PharmacySubscribedUsers", joinColumns = @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Patient_id", referencedColumnName = "id"))
	private Set<Patient> SubscribedUsers = new HashSet<Patient>();
	
	@ManyToMany(mappedBy = "Pharmacies")
	private Set<Dermatologist> Dermatologists = new HashSet<Dermatologist>();
	
	@OneToMany(mappedBy = "Pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Pharmacist> Pharmacists = new HashSet<Pharmacist>();
	
	@OneToMany(mappedBy = "Pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PharmacyAdmin> PharmacyAdmins = new HashSet<PharmacyAdmin>();
	
	public Pharmacy() {}

	public Pharmacy(long id,String name, String address, Set<Integer> marks,Set<MedicinePriceAndQuantity> pricelist,Set<Patient> subscribedUsers) {
		super();
		Id=id;
		Name = name;
		Address = address;
		Marks = marks;
		Pricelist=pricelist;
		SubscribedUsers=subscribedUsers;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Set<Integer> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Integer> marks) {
		Marks = marks;
	}
}
