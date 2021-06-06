package rs.ac.uns.ftn.informatika.jpa.model;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import rs.ac.uns.ftn.informatika.jpa.validator.CustomAnnotation;

@Inheritance(strategy=TABLE_PER_CLASS)
@Entity
@Table(name="USERS")
public class User  implements UserDetails  {
	
	@Id
	@SequenceGenerator(name = "Id", sequenceName = "Id1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id")
	private Long Id;

	
	@CustomAnnotation(message="Field cannot be empty")
	@Column(name="Email", unique=false, nullable=false)
	private String Email;

	@CustomAnnotation(message="Field cannot be empty")
	@Column(name="Password", unique=false, nullable=false)
	private String Password;
	@Column(name="Name", unique=false, nullable=false)
	private String Name;
	@Column(name="Surname", unique=false, nullable=false)
	private String Surname;
	@Column(name="Address", unique=false, nullable=true)
	private String Address;
	@Column(name="City", unique=false, nullable=false)
	private String City;
	@Column(name="Country", unique=false, nullable=false)
	private String Country;
	@Column(name="PhoneNumber", unique=false, nullable=false)
	private String PhoneNumber;
	@Column(name="Description", unique=false, nullable=true)
	private String Description;
	
	@Column(name="EmailComfirmed", unique=false, nullable=false)
	private Boolean EmailComfirmed;
	
	@Column(name="FirstTimeLogin", unique=false, nullable=false)
	private Boolean FirstTimeLogin;
	
	@CustomAnnotation(message="Field cannot be empty")
	@Column(name="Username", unique=true, nullable=false)
	private String username;
	

	
    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "last_password_reset_date")
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
	public Long getId() {
		return Id;
	}
	public void setId(long id) {
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
	public void setId(Long id) {
		Id = id;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String Username) {
		username = Username;
	}

	public User(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String Username) {
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
		username = Username;
	}
	public User(Long id,String name,String surname){
		Id=id;
		Name=name;
		Surname=surname;
	}



	public User(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description) {
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
		Description=description;
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
        return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
