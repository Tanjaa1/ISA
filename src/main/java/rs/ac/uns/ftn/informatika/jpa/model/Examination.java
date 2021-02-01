package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;

public class Examination {
	private long id;
	private String Report;
	private LocalDateTime StartTime;
	private Boolean isDone;
	private Patient Patient;
	private Dermatologist Dermatologist;
	
	public Examination(long id, String report, LocalDateTime startTime, Boolean isDone,
			rs.ac.uns.ftn.informatika.jpa.model.Patient patient,
			rs.ac.uns.ftn.informatika.jpa.model.Dermatologist dermatologist) {
		super();
		this.id = id;
		Report = report;
		StartTime = startTime;
		this.isDone = isDone;
		Patient = patient;
		Dermatologist = dermatologist;
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

	public Dermatologist getDermatologist() {
		return Dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		Dermatologist = dermatologist;
	}
	
	

}
