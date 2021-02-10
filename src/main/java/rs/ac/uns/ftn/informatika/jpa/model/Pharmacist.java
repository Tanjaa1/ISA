package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

@Entity
@Table(name="Pharmacist")
public class Pharmacist extends User {
	
	@ManyToMany
	@JoinTable(name = "PharmacistVacationSchedule", joinColumns = @JoinColumn(name = "Pharmacist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "VacationInterval_id", referencedColumnName = "id"))
	private Set<VacationInterval> VacationSchedule = new HashSet<VacationInterval>();
	
	@ManyToMany
	@JoinTable(name = "PharmacistWorkingSchedule", joinColumns = @JoinColumn(name = "Pharmacist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "WorkingTime_id", referencedColumnName = "id"))
	private Set<WorkingTime> WorkingSchedule = new HashSet<WorkingTime>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;
	
	@Column(name="Marks", unique=false, nullable=true)
	@ElementCollection
	private Set<Integer> Marks = new HashSet<Integer>();
	
	// @OneToMany(mappedBy = "Pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Counseling> Counselings = new HashSet<Counseling>();
	
	public Pharmacist(){}
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

	public Pharmacist(Long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String description, Boolean emailComfirmed, Boolean firstTimeLogin,
			String username, Set<VacationInterval> vacationSchedule, Set<WorkingTime> workingSchedule,
			Pharmacy pharmacy, Set<Integer> marks, Set<Counseling> counselings) {
		super(id, email, password, name, surname, address, city, country, phoneNumber, description, emailComfirmed,
				firstTimeLogin, username);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacy = pharmacy;
		Marks = marks;
	}

	public String getFullName(){
		return getName()+" "+getSurname();
	}
	public boolean checkWorkingTime(LocalDateTime startTime) {
		for (WorkingTime workingTime : WorkingSchedule) {
			LocalTime lt1 = startTime.toLocalTime();
			LocalTime lt2 = workingTime.getTimeStart().toLocalTime();
			LocalTime lt3 = workingTime.getTimeEnd().toLocalTime();
			 int start = lt2.compareTo(lt1);
			 int end = lt3.compareTo(lt1);
			if(start < 0 && end > 0){
				return true;
			}
		}
		return false;
	}
	public boolean checkVacationTime(LocalDateTime startTime) {
		for (VacationInterval vacationTime : VacationSchedule) {
			//LocalDateTime startDateTime = LocalDateTime.ofInstant(vacationTime.getDateStart().toInstant(), ZoneId.systemDefault());
			Date startDate = Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());
			int start = vacationTime.getDateStart().compareTo(startDate);
			int end = vacationTime.getDateEnd().compareTo(startDate);
			if(start > 0 || end < 0){
				return true;
			}
		}
		return false;
	}
}
