package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@Column(name="Marks", unique=false, nullable=true)
	@ElementCollection
	private Set<Integer> Marks = new HashSet<Integer>();
	
	// @OneToMany(mappedBy = "Dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Examination> Examinations = new HashSet<Examination>();
	
	public Dermatologist(){}

	public Dermatologist(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber,String description, Set<VacationInterval> vacationSchedule,
			Set<WorkingTime> workingSchedule, Set<Pharmacy> pharmacies,Set<Integer> marks) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacies = pharmacies;
		Marks=marks;
	}

	public Set<VacationInterval> getVacationSchedule() {
		return VacationSchedule;
	}

	public void setVacationSchedule(Set<VacationInterval> vacationSchedule) {
		VacationSchedule = vacationSchedule;
	}

	public Set<WorkingTime> getWorkingSchedule() {
		return WorkingSchedule;
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

	public Set<Integer> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Integer> marks) {
		Marks = marks;
	}

	public Set<Examination> getExaminations() {
		return Examinations;
	}
	
}
