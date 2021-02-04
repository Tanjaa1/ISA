package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Entity
@Table(name="Pharmacist")
public class Pharmacist extends User {
	
	@OneToMany(mappedBy = "Pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<VacationInterval> VacationSchedule = new HashSet<VacationInterval>();
	
	@OneToMany(mappedBy = "Pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<WorkingTime> WorkingSchedule = new HashSet<WorkingTime>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;
	
	@Column(name="Marks", unique=false, nullable=true)
	@ElementCollection
	private Set<Integer> Marks = new HashSet<Integer>();
	
	@OneToMany(mappedBy = "Pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Counseling> Counselings = new HashSet<Counseling>();
	
	public Pharmacist(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description, Set<VacationInterval> vacationSchedule,
			Set<WorkingTime> workingSchedule, Pharmacy pharmacy,Set<Integer> marks) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacy = pharmacy;
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

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}

	public Set<Integer> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Integer> marks) {
		Marks = marks;
	}
}
