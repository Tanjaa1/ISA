package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ElementCollection
	private List<String> DrugAllargies ;
	
	@Column(name="Points", unique=false, nullable=true)
	private Integer Points;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Penaltys> Penalty=new HashSet<Penaltys>();
	
	@Column(name="Category", unique=false, nullable=true)
	private LoyaltyCategories Category; 
	
	@ManyToMany(mappedBy="SubscribedUsers")
	private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<EPrescription> EPrescriptions = new HashSet<EPrescription>();

	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private Set<ActionOrPromotion> ActionOrPromotions = new HashSet<ActionOrPromotion>();
	
	
	public Patient() {
		Points=0;
	}

	public Patient(Long id, String email, String password, String name, String surname,String phoneNumber,String usermane)
	{
		id = id;
		email = email;
		password = password;
		name = name;
		surname = surname;
		usermane=usermane;
		phoneNumber = phoneNumber;
	}
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
		Points = patientDTO.getPoints();
		Category = patientDTO.getCategory();

	}
	


	public Patient(Long id, String name, String surname,List<String>drugAllergies) {
		super(id, name, surname);
		DrugAllargies=drugAllergies;
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
		EPrescriptions = ePrescriptions;
	
	}
	public Patient(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username, List<String> drugAllargies, Integer points, Set<Penaltys> penalty, LoyaltyCategories category, Set<Complaint> complaints, Set<Counseling> counselings,
			Set<EPrescription> ePrescriptions, Set<Examination> examinations, Set<Reservation> reservations,Set<ActionOrPromotion> actionOrPromotions) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
		ActionOrPromotions=actionOrPromotions;
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
