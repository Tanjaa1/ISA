package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class PharmacyAdminDTO {
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
    private String UserName;
	private Pharmacy Pharmacy;

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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Pharmacy getPharmacy() {
        return Pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        Pharmacy = pharmacy;
    }

    public PharmacyAdminDTO(String email, String password, String name, String surname, String address, String city,
            String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
            String userName, rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy) {
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
        UserName = userName;
        Pharmacy = pharmacy;
    }

}
