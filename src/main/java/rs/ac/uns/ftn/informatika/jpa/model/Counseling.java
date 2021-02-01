package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;

public class Counseling {
	private long id;
	private String Report;
	private LocalDateTime StartTime;
	private Boolean isDone;
	private Patient Patient;
	private Pharmacist Pharmacist;
	
	public Counseling(long id, String report, LocalDateTime startTime, Boolean isDone,
			rs.ac.uns.ftn.informatika.jpa.model.Patient patient,
			rs.ac.uns.ftn.informatika.jpa.model.Pharmacist pharmacist) {
		super();
		this.id = id;
		Report = report;
		StartTime = startTime;
		this.isDone = isDone;
		Patient = patient;
		Pharmacist = pharmacist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public LocalDateTime getStartTime() {
		return StartTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		StartTime = startTime;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	public Pharmacist getPharmacist() {
		return Pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		Pharmacist = pharmacist;
	}
}
