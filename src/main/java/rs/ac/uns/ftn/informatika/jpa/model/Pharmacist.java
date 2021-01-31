package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;
import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

public class Pharmacist extends User {
	private ArrayList<VacationInterval> VacationSchedule;
	private ArrayList<WorkingTime> WorkingSchedule;
	private Pharmacy Pharmacy;
	
	public Pharmacist(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description, ArrayList<VacationInterval> vacationSchedule,
			ArrayList<WorkingTime> workingSchedule, rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		VacationSchedule = vacationSchedule;
		WorkingSchedule = workingSchedule;
		Pharmacy = pharmacy;
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

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}
	
	
	
}
