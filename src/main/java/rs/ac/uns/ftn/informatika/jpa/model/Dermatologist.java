package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

public class Dermatologist extends User{
	private ArrayList<VacationInterval> VacationSchedule;
	private ArrayList<WorkingTime> WorkingSchedule;
	private ArrayList<Pharmacy> Pharmacies;
	
	public Dermatologist(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber,String description, ArrayList<VacationInterval> vacationSchedule,
			ArrayList<WorkingTime> workingSchedule, ArrayList<Pharmacy> pharmacies) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacies = pharmacies;
	}

	public ArrayList<VacationInterval> getVacationSchedule() {
		return VacationSchedule;
	}

	public void setVacationSchedule(ArrayList<VacationInterval> vacationSchedule) {
		VacationSchedule = vacationSchedule;
	}

	public ArrayList<WorkingTime> getWorkingSchedule() {
		return WorkingSchedule;
	}

	public void setWorkingSchedule(ArrayList<WorkingTime> workingSchedule) {
		WorkingSchedule = workingSchedule;
	}

	public ArrayList<Pharmacy> getPharmacies() {
		return Pharmacies;
	}

	public void setPharmacies(ArrayList<Pharmacy> pharmacies) {
		Pharmacies = pharmacies;
	}
}
