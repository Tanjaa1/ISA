package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;

public class PatientDTO {

	private Long Id;
	private String Email;
	private String Password;
	private String Name;
	private String Surname;
	private String Address;
	private String City;
	private String Country;
	private String PhoneNumber;
	private String Username;
	private String Description;
	private Boolean EmailComfirmed;
	private Boolean FirstTimeLogin;
	private Set<String> DrugAllargies = new HashSet<String>();
	private Integer Points;
	private Set<PenaltysDTO> Penalty = new HashSet<PenaltysDTO>();
	private LoyaltyCategories Category; 
	//private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	private Set<Complaint> Complaints = new HashSet<Complaint>();
	private Set<CouncelingDTO> Counselings = new HashSet<CouncelingDTO>();
	private Set<EPrescriptionDTO> EPrescriptions = new HashSet<EPrescriptionDTO>();
	private Set<ExaminationDTO> Examinations = new HashSet<ExaminationDTO>();
	private Set<ActionOrPromotionsDTO> ActionOrPromotions = new HashSet<ActionOrPromotionsDTO>();
	//private Set<Reservation> Reservations = new HashSet<Reservation>();
	
	public PatientDTO() {}
	
	public PatientDTO(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			Set<String> drugAllargies, Integer points, Set<PenaltysDTO> penalty, LoyaltyCategories category, Set<Complaint> complaints, Set<CouncelingDTO> counselings,
			Set<EPrescriptionDTO> ePrescriptions, Set<ExaminationDTO> examinations, Set<ActionOrPromotionsDTO> actionOrPromotions,String usermane/*, Set<Reservation> reservations*/) {
		super();
		Id = id;
		Email = email;
		Password = password;
		Name = name;
		Surname = surname;
		Address = address;
		City = city;
		Username=usermane;
		Country = country;
		PhoneNumber = phoneNumber;
		Description = description;
		EmailComfirmed = emailComfirmed;
		FirstTimeLogin = firstTimeLogin;
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
		//PrepaidPharmacies = prepaidPharmacies;
	//	PrepaidPharmacies = prepaidPharmacies;
		Complaints = complaints;
		Counselings = counselings;
		EPrescriptions = ePrescriptions;
		Examinations = examinations;
		ActionOrPromotions = actionOrPromotions;
		//Reservations = reservations;
	}
	
	public PatientDTO(Patient patient) {
		Id = patient.getId();
		Email = patient.getEmail();
		Password = patient.getPassword();
		Name = patient.getName();
		Surname = patient.getSurname();
		Address = patient.getAddress();
		City = patient.getCity();
		Country = patient.getCountry();
		PhoneNumber = patient.getPhoneNumber();
		Username=patient.getUsername();
		Description = patient.getDescription();
		EmailComfirmed = patient.getEmailComfirmed();
		FirstTimeLogin = patient.getFirstTimeLogin();
		for (String da : patient.getDrugAllargies()) {
			DrugAllargies.add(da);
		}
		Points = patient.getPoints();
		for (Penaltys penaltys : patient.getPenalty()) {
			Penalty.add(new PenaltysDTO(penaltys));
		}
		Category = patient.getCategory();
		// PrepaidPharmacies = patient.getPrepaidPharmacies();
		 for (ActionOrPromotion actionOrPromotion : patient.getActionOrPromotion()) {
		 	ActionOrPromotions.add(new ActionOrPromotionsDTO(actionOrPromotion));
		 }
		//Complaints = patient.getComplaints();
		//Counselings = patient.getCounselings();
		for (EPrescription ePrescription : patient.getEPrescriptions()) {
			EPrescriptions.add(new EPrescriptionDTO(ePrescription));
		}
		//Examinations = patient.getExaminations();
		//Reservations = patient.getReservations();
	}
	
	public Long getId(){
		return Id;
	}

	public void setId(Long id){
		Id = id;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Boolean getEmailComfirmed() {
		return EmailComfirmed;
	}
	public void setEmailComfirmed(Boolean emailComfirmed) {
		EmailComfirmed = emailComfirmed;
	}
	public Boolean getFirstTimeLogin() {
		return FirstTimeLogin;
	}
	public void setFirstTimeLogin(Boolean firstTimeLogin) {
		FirstTimeLogin = firstTimeLogin;
	}
	public Set<String> getDrugAllargies() {
		return DrugAllargies;
	}
	public void setDrugAllargies(Set<String> drugAllargies) {
		for (String patientAllergie : drugAllargies) {
			DrugAllargies.add(patientAllergie);
		}
	}
	public Integer getPoints() {
		return Points;
	}
	public void setPoints(Integer points) {
		Points = points;
	}
	public Set<PenaltysDTO> getPenalty() {
		return Penalty;
	}
	public void setPenalty(Set<PenaltysDTO> penalty) {
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
	public Set<Complaint> getComplaints() {
		return Complaints;
	}
	public void setComplaints(Set<Complaint> complaints) {
		Complaints = complaints;
	}
	public Set<CouncelingDTO> getCounselings() {
		return Counselings;
	}
	public void setCounselings(Set<CouncelingDTO> counselings) {
		Counselings = counselings;
	}
	public Set<EPrescriptionDTO> getEPrescriptions() {
		return EPrescriptions;
	}
	public void setEPrescriptions(Set<EPrescriptionDTO> ePrescriptions) {
		EPrescriptions = ePrescriptions;
	}
	public Set<ExaminationDTO> getExaminations() {
		return Examinations;
	}
	public void setExaminations(Set<ExaminationDTO> examinations) {
		Examinations = examinations;
	}

	public Set<ActionOrPromotionsDTO> getActionOrPromotions() {
		return ActionOrPromotions;
	}
	public void setActionOrPromotions(Set<ActionOrPromotionsDTO> actionOrPromotions) {
		ActionOrPromotions = actionOrPromotions;
	}

	// public Set<Reservation> getReservations() {
	// 	return Reservations;
	// }
	// public void setReservations(Set<Reservation> reservations) {
	// 	Reservations = reservations;
	// }

	public boolean containsNameAndSurname(String name, String surname) {
		return Name.toUpperCase().contains(name.toUpperCase().trim()) 
			&& Surname.toUpperCase().contains(surname.toUpperCase().trim());
	}
	public String fullName(){
		return Name+" "+Surname;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
	
}
