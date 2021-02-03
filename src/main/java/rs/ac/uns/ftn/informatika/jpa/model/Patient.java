package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;

@Entity
@Table(name="Patient")
public class Patient extends User {
	
	@Column(name="DrugAllargies", unique=false, nullable=true)
	@ElementCollection
	private Set<String> DrugAllargies = new HashSet<String>();
	
	@Column(name="Points", unique=false, nullable=true)
	private Integer Points;
	
	@Column(name="Penalty", unique=false, nullable=true)
	private Integer Penalty;
	
	@Column(name="Category", unique=false, nullable=true)
	private LoyaltyCategories Category; 
	
	@ManyToMany(mappedBy = "SubscribedUsers")
	private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Complaint> Complaints = new HashSet<Complaint>();
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Counseling> Counselings = new HashSet<Counseling>();
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EPrescription> EPrescriptions = new HashSet<EPrescription>();
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> Examinations = new HashSet<Examination>();
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Reservation> Reservations = new HashSet<Reservation>();
	
	public Patient() {}
	
	public Patient(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description, Set<String> drugAllargies, int points, int penalty,
			LoyaltyCategories category) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
	}

	public Set<String> getDrugAllargies() {
		return DrugAllargies;
	}

	public void setDrugAllargies(Set<String> drugAllargies) {
		DrugAllargies = drugAllargies;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}

	public int getPenalty() {
		return Penalty;
	}

	public void setPenalty(int penalty) {
		Penalty = penalty;
	}

	public LoyaltyCategories getCategory() {
		return Category;
	}

	public void setCategory(LoyaltyCategories category) {
		Category = category;
	}
	
	
	
}
