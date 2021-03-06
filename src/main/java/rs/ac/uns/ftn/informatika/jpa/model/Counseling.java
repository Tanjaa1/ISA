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

import rs.ac.uns.ftn.informatika.jpa.validator.CustomAnnotation;

@Entity
@Table(name="Counseling")
public class Counseling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Report", unique=false, nullable=true)
	private String Report;
	
	@CustomAnnotation(message="Field cannot be empty")
	@Column(name="StartTime", unique=false, nullable=true)
	private LocalDateTime StartTime;
	
	@CustomAnnotation(message="Field cannot be empty")
	@Column(name="EndTime", unique=false, nullable=true)
	private LocalDateTime EndTime;
	
	@Column(name="isDone", unique=false, nullable=true)
	private Boolean isDone;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties(value = {"Counseling", "hibernateLazyInitializer"})
	private Patient Patient;
	
	@CustomAnnotation(message="Field cannot be empty")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties(value = {"Counseling", "hibernateLazyInitializer"})
	private Pharmacist Pharmacist;

	@CustomAnnotation(message="Field cannot be empty")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties(value = {"Counseling", "hibernateLazyInitializer"})
	private Pharmacy Pharmacy;
	
	@Column(name="Price", unique=false, nullable=true)
	private Double Price;

	@Column(name="IsCanceled", unique=false, nullable=true)
	private Boolean IsCanceled;

	public Counseling(){
		Pharmacy=new Pharmacy();
		Pharmacist=new Pharmacist();
	}

	public Counseling(Long id, String report, LocalDateTime startTime, Double price, Boolean isDone,
			rs.ac.uns.ftn.informatika.jpa.model.Patient patient,
			rs.ac.uns.ftn.informatika.jpa.model.Pharmacist pharmacist, Boolean isCanceled) {
		super();
		this.id = id;
		Report = report;
		StartTime = startTime;
		Price = price;
		this.isDone = isDone;
		Patient = patient;
		Pharmacist = pharmacist;
		IsCanceled = isCanceled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public LocalDateTime getEndTime() {
		return EndTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		EndTime = endTime;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
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

	public Boolean getIsCanceled() {
		return IsCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		IsCanceled = isCanceled;
	}
}
