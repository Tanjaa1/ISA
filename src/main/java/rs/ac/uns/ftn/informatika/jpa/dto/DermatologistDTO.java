package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class DermatologistDTO {

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
	private List<String> Pharmacies = new ArrayList<String>();

	public DermatologistDTO() {
	}

	public DermatologistDTO(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin) {
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
	}

	public DermatologistDTO(Dermatologist dermatologist) {
		super();
		Id = dermatologist.getId();
		Email = dermatologist.getEmail();
		Password = dermatologist.getPassword();
		Name = dermatologist.getName();
		Surname = dermatologist.getSurname();
		Address = dermatologist.getAddress();
		City = dermatologist.getCity();
		Country = dermatologist.getCountry();
		PhoneNumber = dermatologist.getPhoneNumber();
		Description = dermatologist.getDescription();
		EmailComfirmed = dermatologist.getEmailComfirmed();
		FirstTimeLogin = dermatologist.getFirstTimeLogin();
		for ( Pharmacy pharmacy:dermatologist.getPharmacies())
			Pharmacies.add(pharmacy.getName());
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
	public List<String> getPharmacies() {
		return Pharmacies;
	}
	public void setPharmacies(List<String> pharmacies) {
		Pharmacies = pharmacies;
	}
}
