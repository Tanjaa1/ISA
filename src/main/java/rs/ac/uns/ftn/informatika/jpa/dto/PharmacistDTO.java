package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class PharmacistDTO {

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
	private Set<Integer> Marks = new HashSet<Integer>();
	private Pharmacy Pharmacy ;



	public PharmacistDTO() {
	}

	public PharmacistDTO(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin, Set<Integer> marks ,Pharmacy pharmacy
			) {
		super();
		Pharmacy = pharmacy;
		Marks = marks;
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
	}

	public PharmacistDTO(Pharmacist pharmaciest) {
		super();
		Pharmacy = pharmaciest.getPharmacy();
		Marks = pharmaciest.getMarks();
		Id = pharmaciest.getId();
		Email = pharmaciest.getEmail();
		Password = pharmaciest.getPassword();
		Name = pharmaciest.getName();
		Surname = pharmaciest.getSurname();
		Address = pharmaciest.getAddress();
		City = pharmaciest.getCity();
		Country = pharmaciest.getCountry();
		PhoneNumber = pharmaciest.getPhoneNumber();
		Description = pharmaciest.getDescription();
		EmailComfirmed = pharmaciest.getEmailComfirmed();
		FirstTimeLogin = pharmaciest.getFirstTimeLogin();
	}

	
	public Long getId(){
		return Id;
	}

	public void setId(Long id){
		Id = id;
	}

	public Set<Integer> getMarks(){
		return Marks;
	}

	public void setMarks(Set<Integer> Marks){
		this.Marks = Marks;
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
	public Pharmacy getPharmacy() {
		return Pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}
}
