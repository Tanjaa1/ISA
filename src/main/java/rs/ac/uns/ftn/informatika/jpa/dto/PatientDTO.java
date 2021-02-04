package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

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
	private String Description;
	private Boolean EmailComfirmed;
	private Boolean FirstTimeLogin;
	private Set<String> DrugAllargies = new HashSet<String>();
	private Integer Points;
	private Integer Penalty;
	private LoyaltyCategories Category; 
	private Set<Pharmacy> PrepaidPharmacies = new HashSet<Pharmacy>();
	private Set<Complaint> Complaints = new HashSet<Complaint>();
	private Set<Counseling> Counselings = new HashSet<Counseling>();
	private Set<EPrescription> EPrescriptions = new HashSet<EPrescription>();
	private Set<Examination> Examinations = new HashSet<Examination>();
	//private Set<Reservation> Reservations = new HashSet<Reservation>();
	
	public PatientDTO() {}
	
	public PatientDTO(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			Set<String> drugAllargies, Integer points, Integer penalty, LoyaltyCategories category,
			Set<Pharmacy> prepaidPharmacies, Set<Complaint> complaints, Set<Counseling> counselings,
			Set<EPrescription> ePrescriptions, Set<Examination> examinations/*, Set<Reservation> reservations*/) {
		super();
		Id = id;
		Email = email;
		Password = password;
		Name = name;
		Surname = surname;
		Address = address;
		City = city;
		Country = country;
		PhoneNumber = phoneNumber;
		Description = description;
		EmailComfirmed = emailComfirmed;
		FirstTimeLogin = firstTimeLogin;
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
		PrepaidPharmacies = prepaidPharmacies;
		Complaints = complaints;
		Counselings = counselings;
		EPrescriptions = ePrescriptions;
		Examinations = examinations;
		//Reservations = reservations;
	}
	
	public PatientDTO(Patient patient) {
		super();
		Id = patient.getId();
		Email = patient.getEmail();
		Password = patient.getPassword();
		Name = patient.getName();
		Surname = patient.getSurname();
		Address = patient.getAddress();
		City = patient.getCity();
		Country = patient.getCountry();
		PhoneNumber = patient.getPhoneNumber();
		Description = patient.getDescription();
		EmailComfirmed = patient.getEmailComfirmed();
		FirstTimeLogin = patient.getFirstTimeLogin();
		for (String da : patient.getDrugAllargies()) {
			DrugAllargies.add(da);
		}
		Points = patient.getPoints();
		Penalty = patient.getPenalty();
		Category = patient.getCategory();
		PrepaidPharmacies = patient.getPrepaidPharmacies();
		//Complaints = patient.getComplaints();
		//Counselings = patient.getCounselings();
		//EPrescriptions = patient.getEPrescriptions();
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
	public Integer getPenalty() {
		return Penalty;
	}
	public void setPenalty(Integer penalty) {
		Penalty = penalty;
	}
	public LoyaltyCategories getCategory() {
		return Category;
	}
	public void setCategory(LoyaltyCategories category) {
		Category = category;
	}
	public Set<Pharmacy> getPrepaidPharmacies() {
		return PrepaidPharmacies;
	}
	public void setPrepaidPharmacies(Set<Pharmacy> prepaidPharmacies) {
		PrepaidPharmacies = prepaidPharmacies;
	}
	public Set<Complaint> getComplaints() {
		return Complaints;
	}
	public void setComplaints(Set<Complaint> complaints) {
		Complaints = complaints;
	}
	public Set<Counseling> getCounselings() {
		return Counselings;
	}
	public void setCounselings(Set<Counseling> counselings) {
		Counselings = counselings;
	}
	public Set<EPrescription> getEPrescriptions() {
		return EPrescriptions;
	}
	public void setEPrescriptions(Set<EPrescription> ePrescriptions) {
		EPrescriptions = ePrescriptions;
	}
	public Set<Examination> getExaminations() {
		return Examinations;
	}
	public void setExaminations(Set<Examination> examinations) {
		Examinations = examinations;
	}
	// public Set<Reservation> getReservations() {
	// 	return Reservations;
	// }
	// public void setReservations(Set<Reservation> reservations) {
	// 	Reservations = reservations;
	// }
	
	
	
}
