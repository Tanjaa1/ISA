package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Counseling")
public class Counseling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Report", unique=false, nullable=true)
	private String Report;
	
	@Column(name="StartTime", unique=false, nullable=true)
	private LocalDateTime StartTime;
	
	@Column(name="isDone", unique=false, nullable=true)
	private Boolean isDone;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient Patient;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacist Pharmacist;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;
	
	public Counseling(){}

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

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}
}
