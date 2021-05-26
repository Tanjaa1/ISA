package rs.ac.uns.ftn.informatika.jpa.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public class PharmacyAdminDTO {
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
    private String Username;
	private PharmacyDTO Pharmacy;


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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String userName) {
        Username = userName;
    }

    public PharmacyDTO getPharmacy() {
        return Pharmacy;
    }

    public void setPharmacy(PharmacyDTO pharmacy) {
        Pharmacy = pharmacy;
    }

    public PharmacyAdminDTO() {

    }

    public PharmacyAdminDTO(Long id,String email, String password, String name, String surname, String address, String city,
            String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
            String userName, PharmacyDTO pharmacy) {
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
        Username = userName;
        Pharmacy = pharmacy;
    }
   
 
    public PharmacyAdminDTO(String email, String password, String name, String surname, String address, String city,
            String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
            String username, PharmacyDTO pharmacy,Long id) {
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
        Username = username;
        Pharmacy = pharmacy;
        Id = id;
    }
    
    public PharmacyAdminDTO(PharmacyAdmin pa) {
        Email = pa.getEmail();
        Id=pa.getId();
        Password = pa.getPassword();
        Name = pa.getName();
        Surname = pa.getSurname();
        Address = pa.getAddress();
        City = pa.getCity();
        Country = pa.getCountry();
        PhoneNumber = pa.getPhoneNumber();
        Description = pa.getDescription();
        EmailComfirmed = pa.getEmailComfirmed();
        FirstTimeLogin = pa.getFirstTimeLogin();
        Username = pa.getUsername();
        Pharmacy = new PharmacyDTO(pa.getPharmacy());
        Id = pa.getId();
    }
	public String fullName(){
		return Name+" "+Surname;
	}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    
}
