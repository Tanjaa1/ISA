package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.VacationIntervalDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.WorkingTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Entity
@Table(name="Dermatologist")
public class Dermatologist extends User{
	
	@ManyToMany
	@JoinTable(name = "DermatologistVacationSchedule", joinColumns = @JoinColumn(name = "Dermatologist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "VacationInterval_id", referencedColumnName = "id"))
	private Set<VacationInterval> VacationSchedule = new HashSet<VacationInterval>();
	
	@ManyToMany
	@JoinTable(name = "DermatologistWorkingSchedule", joinColumns = @JoinColumn(name = "Dermatologist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "WorkingTime_id", referencedColumnName = "id"))
	private Set<WorkingTime> WorkingSchedule = new HashSet<WorkingTime>();
	
	@ManyToMany
	@JoinTable(name = "Pharmacy_dermatologists", joinColumns = @JoinColumn(name = "Dermatologist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id"))
	private Set<Pharmacy> Pharmacies = new HashSet<Pharmacy>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Markk> Marks = new HashSet<Markk>();
	
	public Dermatologist(){}

	public Dermatologist(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber,String description, Set<VacationInterval> vacationSchedule,
			Set<WorkingTime> workingSchedule, Set<Pharmacy> pharmacies,Set<Markk> marks) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacies = pharmacies;
		Marks=marks;
	}

	public Dermatologist(DermatologistDTO d) {
	super(d.getId(), d.getEmail() ,d.getPassword(), d.getName(), d.getSurname(), d.getAddress(), d.getCity(), d.getCountry(), d.getPhoneNumber(),d.getDescription());

	VacationSchedule = new HashSet<VacationInterval>();
	for (VacationIntervalDTO v : d.getVacationSchedule()) {
		VacationSchedule.add(new VacationInterval(v));
	}

	WorkingSchedule = new HashSet<WorkingTime>();
	for (WorkingTimeDTO w : d.getWorkingSchedule()) {
		WorkingSchedule.add(new WorkingTime(w));
	}

	Pharmacies = new HashSet<Pharmacy>();
	for (PharmacyDTO p : d.getPharmacies()) {
		Pharmacies.add(new Pharmacy(p));
	}
	
	Marks= new HashSet<Markk>();

	
	}


	public Set<VacationInterval> getVacationSchedule() {
		return VacationSchedule;
	}

	
	public Set<VacationIntervalDTO> getVacationScheduleAsDTO() {
		Set<VacationIntervalDTO> retVal = new HashSet<VacationIntervalDTO> ();
		for(VacationInterval vacationInterval : VacationSchedule)
			retVal.add(new VacationIntervalDTO(vacationInterval));
		return retVal;
	}

	public Set<WorkingTimeDTO> getWorkingScheduldeAsDTO() {
		Set<WorkingTimeDTO> retVal = new HashSet<WorkingTimeDTO> ();
		for(WorkingTime workingTime : WorkingSchedule)
			retVal.add(new WorkingTimeDTO(workingTime));
		return retVal;
	}


	public void setVacationSchedule(Set<VacationInterval> vacationSchedule) {
		VacationSchedule = vacationSchedule;
	}

	public Set<WorkingTime> getWorkingSchedule() {
		return WorkingSchedule;
	}

	public Set<WorkingTime> getWorkingScheduleByPharmacyId(long id) {
		Set<WorkingTime> retVal = new HashSet<WorkingTime>();
		for (WorkingTime wt : WorkingSchedule) {
			if(wt.getPharmacy().getId() == id)
				retVal.add(wt);
		}
		return retVal;
	}


	public void setWorkingSchedule(Set<WorkingTime> workingSchedule) {
		WorkingSchedule = workingSchedule;
	}

	public Set<Pharmacy> getPharmacies() {
		return Pharmacies;
	}

	public void setPharmacies(Set<Pharmacy> pharmacies) {
		Pharmacies = pharmacies;
	}

	public Set<Markk> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Markk> marks) {
		Marks = marks;
	}
	public Dermatologist(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin, String username, Set<VacationInterval> vacationSchedule,
			Set<WorkingTime> workingSchedule, Set<Pharmacy> pharmacies, Set<Markk> marks) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacies = pharmacies;
		Marks = marks;
	}
	
	public Dermatologist(Long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, String description, Boolean emailComfirmed,
			Boolean firstTimeLogin, String username,  Set<Pharmacy> pharmacies) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		Pharmacies = pharmacies;
	
	}

	public String getFullName(){
		return getName()+" "+getSurname();
	}
}
