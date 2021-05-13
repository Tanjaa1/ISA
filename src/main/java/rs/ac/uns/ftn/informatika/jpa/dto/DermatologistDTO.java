package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class DermatologistDTO{


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
	private Set<VacationIntervalDTO> VacationSchedule = new HashSet<VacationIntervalDTO>();
	private Set<WorkingTimeDTO> WorkingSchedule = new HashSet<WorkingTimeDTO>();
	private Set<PharmacyDTO> Pharmacies = new HashSet<PharmacyDTO>();
	private Set<Integer> Marks = new HashSet<Integer>();
    private Set<ExaminationDTO> Examinations = new HashSet<ExaminationDTO>();
	private Double Grade;
    private String Username;
    public DermatologistDTO() {
    }

    public DermatologistDTO(Long Id,String Email,String Password,String Name,String Surname,String Address,String City, String Country,String PhoneNumber,String Description,
    Boolean EmailComfirmed, Boolean FirstTimeLogin ,Set<VacationIntervalDTO> VacationSchedule,Set<WorkingTimeDTO> WorkingSchedule,Set<PharmacyDTO> Pharmacies,
    Set<Integer> Marks,Set<ExaminationDTO> Examinations, Double grade){
      super();
      this.Address = Address;
      this.City = City;
      this.Country = Country;
      this.Description = Description;
      this.Email = Email;
      this.EmailComfirmed = EmailComfirmed;
      this.Examinations = Examinations;
      this.FirstTimeLogin = FirstTimeLogin;
      this.Id = Id;
      this.Marks = Marks; 
      this.Name = Name;
      this.Password = Password;
      this.Pharmacies = Pharmacies;
      this.PhoneNumber = PhoneNumber;
      this.Surname = Surname;
      this.VacationSchedule = VacationSchedule;
      this.WorkingSchedule = WorkingSchedule;
	  Grade = grade;
    }

    public DermatologistDTO(Dermatologist dermatologist){
      super();
      this.Address = dermatologist.getAddress();
      this.City = dermatologist.getCity();
      this.Country = dermatologist.getCountry();
      this.Description = dermatologist.getDescription();
      this.Email = dermatologist.getEmail();
      this.EmailComfirmed = dermatologist.getEmailComfirmed();
      this.FirstTimeLogin = dermatologist.getFirstTimeLogin();
      this.Id = dermatologist.getId();
      this.Name = dermatologist.getName();
      this.Password = dermatologist.getPassword();
	  for (Pharmacy pharmacy : dermatologist.getPharmacies()) {
		  Pharmacies.add(new PharmacyDTO(pharmacy));
	  }
      this.PhoneNumber = dermatologist.getPhoneNumber();
      this.Surname = dermatologist.getSurname();
      this.VacationSchedule = dermatologist.getVacationScheduleAsDTO();
      this.WorkingSchedule = dermatologist.getWorkingScheduldeAsDTO();
	  double result =  0;
        int i = 0;
        for (Markk m : dermatologist.getMarks()) {
			result += m.getMarks();
			i++;
		}
		if(i != 0)
			Grade = (double) Math.round(result / i * 10) / 10;
		Username=dermatologist.getUsername();
    }

    public DermatologistDTO toDTO(Dermatologist dermatologist){
        return new DermatologistDTO(dermatologist);
    }

    public Long getId() {
		return Id;
	}
	public void setId(Long id) {
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


    public Set<VacationIntervalDTO> getVacationSchedule() {
		return VacationSchedule;
	}

	public void setVacationSchedule(Set<VacationIntervalDTO> vacationSchedule) {
		VacationSchedule = vacationSchedule;
	}

	public Set<WorkingTimeDTO> getWorkingSchedule() {
		return WorkingSchedule;
	}

	public void setWorkingSchedule(Set<WorkingTimeDTO> workingSchedule) {
		WorkingSchedule = workingSchedule;
	}

	public Set<PharmacyDTO> getPharmacies() {
		return Pharmacies;
	}

	public void setPharmacies(Set<PharmacyDTO> pharmacies) {
		Pharmacies = pharmacies;
	}

	public Set<Integer> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Integer> marks) {
		Marks = marks;
    }
    
	public Double getGrade() {
		return Grade;
	}

	public void setGrade(Double grade) {
		Grade = grade;
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
	public void setUsername(String username) {
		Username = username;
	}
}

