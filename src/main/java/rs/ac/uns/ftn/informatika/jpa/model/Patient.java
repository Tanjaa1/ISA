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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;

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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Penaltys> Penalty;
	
	@Column(name="Category", unique=false, nullable=true)
	private LoyaltyCategories Category; 
	
	@ManyToMany(mappedBy="SubscribedUsers")
	private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<EPrescription> EPrescriptions = new HashSet<EPrescription>();

	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<ActionOrPromotion> ActionOrPromotions = new HashSet<ActionOrPromotion>();
	
	
	public Patient() {}
	
	public int getPoints() {
		return Points;
	}
	

	public void setPoints(int points) {
		Points = points;
	}

	public Set<Penaltys> getPenalty() {
		return Penalty;
	}

	public void setPenalty(Set<Penaltys> penalty) {
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
		//Penalty = patientDTO.getPenalty();
		Category = patientDTO.getCategory();

	}

	public Patient(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username, List<String> drugAllargies, Integer points, Set<Penaltys> penalty, LoyaltyCategories category, Set<Complaint> complaints, Set<Counseling> counselings,
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

	public Set<Pharmacy> getPrepaidPharmacies(){
		return PrepaidPharmacies;
	}

	public void setPrepaidPharmacies(Set<Pharmacy> pp){
		PrepaidPharmacies = pp;
	}
}
