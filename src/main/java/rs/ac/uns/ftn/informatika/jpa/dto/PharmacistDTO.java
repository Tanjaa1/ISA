package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

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
	private Set<MarkDTO> Marks = new HashSet<MarkDTO>();
	private Integer Grade;
	private PharmacyDTO Pharmacy ;
	private Set<VacationIntervalDTO> VacationSchedule = new HashSet<VacationIntervalDTO>();
	private Set<WorkingTimeDTO> WorkingSchedule = new HashSet<WorkingTimeDTO>();
	private String Username;



	public PharmacistDTO() {
	}

	public PharmacistDTO(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin, Set<MarkDTO> marks ,PharmacyDTO pharmacy, Set<WorkingTimeDTO> workingTime,
			 Set<VacationIntervalDTO> vacationTime, Integer grade
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
		WorkingSchedule = workingTime;
		VacationSchedule = vacationTime;
		Grade = grade;
	}

	public PharmacistDTO(Pharmacist pharmaciest) {
		//super();
		Pharmacy = new PharmacyDTO(pharmaciest.getPharmacy());
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
		for (WorkingTime workingSchedule : pharmaciest.getWorkingSchedule()) {
			WorkingSchedule.add(new WorkingTimeDTO(workingSchedule));
		}
		for (VacationInterval vacationSchedule : pharmaciest.getVacationSchedule()) {
			VacationSchedule.add(new VacationIntervalDTO(vacationSchedule));
		}
		for (Markk mark : pharmaciest.getMarks()) {
			Marks.add(new MarkDTO(mark));
		}
		double result =  0;
        int i = 0;
        for (Markk m : pharmaciest.getMarks()) {
            result += m.getMarks();
            i++;
        }
        Grade = (int) Math.round(result / i);
		Username=pharmaciest.getUsername();
	}

	
	public Long getId(){
		return Id;
	}

	public void setId(Long id){
		Id = id;
	}

	public Set<MarkDTO> getMarks(){
		return Marks;
	}

	public void setMarks(Set<MarkDTO> Marks){
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
	public PharmacyDTO getPharmacy() {
		return Pharmacy;
	}
	public void setPharmacy(PharmacyDTO pharmacy) {
		Pharmacy = pharmacy;
	}

	public Set<WorkingTimeDTO> getWorkingSchedule() {
		return WorkingSchedule;
	}
	public void setWorkingSchedule(Set<WorkingTimeDTO> workingTime) {
		WorkingSchedule = workingTime;
	}

	public Set<VacationIntervalDTO> getVacationSchedule() {
		return VacationSchedule;
	}
	public void setPharmacy(Set<VacationIntervalDTO> vacationTime) {
		VacationSchedule = vacationTime;
	}

	public Integer getGrade() {
		return Grade;
	}

	public void setGrade(Integer grade) {
		Grade = grade;
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
}
