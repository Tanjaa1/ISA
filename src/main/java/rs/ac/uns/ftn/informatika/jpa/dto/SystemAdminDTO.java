package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdmin;

public class SystemAdminDTO {
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
    private Set<ComplaintAnswer> Complaints = new HashSet<ComplaintAnswer>();

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

    public Set<ComplaintAnswer> getComplaints() {
        return Complaints;
    }

    public void setComplaints(Set<ComplaintAnswer> complaints) {
        Complaints = complaints;
    }

    public SystemAdminDTO(String email, String password, String name, String surname, String address, String city,
            String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
            Set<ComplaintAnswer> complaints) {
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
        Complaints = complaints;
    }
    public SystemAdminDTO(Long id,String email, String password, String name, String surname, String address, String city,
            String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
            Set<ComplaintAnswer> complaints) {
        Id=id;
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
        Complaints = complaints;
    }
    
    
    public SystemAdminDTO(SystemAdmin systemAdmin){
        Id=systemAdmin.getId();
        Email = systemAdmin.getEmail();
        Password = systemAdmin.getPassword();
        Name = systemAdmin.getName();
        Surname = systemAdmin.getSurname();
        Address = systemAdmin.getAddress();
        City = systemAdmin.getCity();
        Country = systemAdmin.getCountry();
        PhoneNumber = systemAdmin.getPhoneNumber();
        Description = systemAdmin.getDescription();
        EmailComfirmed = systemAdmin.getEmailComfirmed();
        FirstTimeLogin = systemAdmin.getFirstTimeLogin();
       // Complaints = systemAdmin.getComplaintAnswers();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
	
}
