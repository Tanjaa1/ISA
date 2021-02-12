package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;

@Entity
@Table(name="Patient")
public class Patient extends User {
	
	@Column(name="DrugAllargies", unique=false, nullable=true)
	//@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ElementCollection
	//private Set<String> DrugAllargies = new HashSet<String>();
	private List<String> DrugAllargies ;
	
	@Column(name="Points", unique=false, nullable=true)
	private Integer Points;
	
	@Column(name="Penalty", unique=false, nullable=true)
	private Integer Penalty;
	
	@Column(name="Category", unique=false, nullable=true)
	private LoyaltyCategories Category; 
	/*
	//@ManyToMany(mappedBy = "SubscribedUsers")
	// @ManyToMany
	// @JoinTable(name = "PharmacySubscribedUsers", joinColumns = @JoinColumn(name = "Patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id"))
	// private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	
	@ManyToMany
	@JoinTable(name = "PharmacySubscribedUsers", joinColumns = @JoinColumn(name = "Patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id"))
	private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	*/
	// @OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Complaint> Complaints = new HashSet<Complaint>();
	
	// @OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Counseling> Counselings = new HashSet<Counseling>();
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<EPrescription> EPrescriptions = new HashSet<EPrescription>();

	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<ActionOrPromotion> ActionOrPromotions = new HashSet<ActionOrPromotion>();
	
	// @OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Examination> Examinations = new HashSet<Examination>();
	
	// @JsonManagedReference(value = "reservation_pat")
	// @OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Reservation> Reservations = new HashSet<Reservation>();
	
	public Patient() {}
	/*
	public Patient(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description, Set<String> drugAllargies, int points, int penalty,
			LoyaltyCategories category, Set<ActionOrPromotion> actionOrPromotions) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
		ActionOrPromotions = actionOrPromotions;
	}

	public Set<String> getDrugAllargies() {
		return DrugAllargies;
	}

	public void setDrugAllargies(Set<String> drugAllargies) {
		DrugAllargies = drugAllargies;
	}
*/
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
	
	// public Set<Pharmacy> getPrepaidPharmacies() {
	// 	return PrepaidPharmacies;
	// }

	// public void setPrepaidPharmacies(Set<Pharmacy> prepaidPharmacies) {
	// 	PrepaidPharmacies = prepaidPharmacies;
	// }

/*	
	public Set<Pharmacy> getPrepaidPharmacies() {
		return PrepaidPharmacies;
	}

	public void setPrepaidPharmacies(Set<Pharmacy> prepaidPharmacies) {
		PrepaidPharmacies = prepaidPharmacies;
	}
*/
	public String getFullName() {
		return getName()+" "+ getSurname();
	}
	
	public Set<ActionOrPromotion> getActionOrPromotion() {
		return ActionOrPromotions;
	}

	public void setActionOrPromotion(Set<ActionOrPromotion> actionOrPromotion) {
		ActionOrPromotions = actionOrPromotion;
	}

	public Patient(PatientDTO patientDTO){
		super();
		//DrugAllargies = patientDTO.getDrugAllargies();
		Points = patientDTO.getPoints();
		Penalty = patientDTO.getPenalty();
		Category = patientDTO.getCategory();

	}

	public Patient(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username, List<String> drugAllargies, Integer points, Integer penalty, LoyaltyCategories category, Set<Complaint> complaints, Set<Counseling> counselings,
			Set<EPrescription> ePrescriptions, Set<Examination> examinations, Set<Reservation> reservations) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
		//PrepaidPharmacies = prepaidPharmacies;
	//	PrepaidPharmacies = prepaidPharmacies;
		EPrescriptions = ePrescriptions;
	
	}

	public List<String> getDrugAllargies() {
		return DrugAllargies;
	}

	public void setDrugAllargies(List<String> drugAllargies) {
		DrugAllargies = drugAllargies;
	}

	public void setPoints(Integer points) {
		Points = points;
	}

	public void setPenalty(Integer penalty) {
		Penalty = penalty;
	}

	public Set<EPrescription> getEPrescriptions() {
		return EPrescriptions;
	}

	public void setEPrescriptions(Set<EPrescription> ePrescriptions) {
		EPrescriptions = ePrescriptions;
	}

	public Set<ActionOrPromotion> getActionOrPromotions() {
		return ActionOrPromotions;
	}

	public void setActionOrPromotions(Set<ActionOrPromotion> actionOrPromotions) {
		ActionOrPromotions = actionOrPromotions;
	}

	public void addEPrescritpion(EPrescription ePrescription)
	{
		EPrescriptions.add(ePrescription);
	}	

	// public Set<Examination> getExaminations() {
	// 	return Examinations;
	// }

	// public void setExaminations(Set<Examination> examinations) {
	// 	Examinations = examinations;
	// }

	// public Set<Complaint> getComplaints() {
	// 	return Complaints;
	// }

	// public void setComplaints(Set<Complaint> complaints) {
	// 	Complaints = complaints;
	// }

	// public Set<Counseling> getCounselings() {
	// 	return Counselings;
	// }

	// public void setCounselings(Set<Counseling> counselings) {
	// 	Counselings = counselings;
	// }

	// public Set<EPrescription> getEPrescriptions() {
	// 	return EPrescriptions;
	// }

	// public void setEPrescriptions(Set<EPrescription> ePrescriptions) {
	// 	EPrescriptions = ePrescriptions;
	// }

	// public Set<Reservation> getReservations() {
	// 	return Reservations;
	// }

	// public void setReservations(Set<Reservation> reservations) {
	// 	Reservations = reservations;
	// }
}
