package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.ac.uns.ftn.informatika.jpa.enums.EPrescriptionStatus;

@Entity
@Table(name="EPrescription")
public class EPrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Code;
	
	@Column(name="IssuingDate", unique=false, nullable=true)
	private Date IssuingDate;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Patient Patient;
	
	// @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private Set<Therapy> Therapies = new HashSet<Therapy>();
	
	// @OneToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "Medicine_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private MedicinePriceAndQuantity Medicine;
	
	// @Column(name="Amount", unique=false, nullable=true)
	// private Integer Amount;
	
	@Column(name="TherapyDuration", unique=false, nullable=true)
	private Integer TherapyDuration;
	
	
	@Column(name="Status", unique=false, nullable=true)
	private EPrescriptionStatus Status; 
	
	@ManyToOne
	(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pharmacy Pharmacy;

	public EPrescription(){
		Status= EPrescriptionStatus.New;
	}

	public EPrescription(Long code, Date issuingDate) {
		super();
		Code = code;
		IssuingDate = issuingDate;
		//Patient = patient;
	}

	public Long getCode() {
		return Code;
	}

	public void setCode(Long code) {
		Code = code;
	}

	public Date getIssuingDate() {
		return IssuingDate;
	}

	public void setIssuingDate(Date issuingDate) {
		IssuingDate = issuingDate;
	}

	// public Patient getPatient() {
	// 	return Patient;
	// }

	// public void setPatient(Patient patient) {
	// 	Patient = patient;
	// }

	// public Set<Therapy> getTherapies() {
	// 	return Therapies;
	// }

	// public void setTherapies(Set<Therapy> therapies) {
	// 	Therapies = therapies;
	// }
	public MedicinePriceAndQuantity getMedicine() {
		return Medicine;
	}
	public void setMedicine(MedicinePriceAndQuantity medicine) {
		Medicine = medicine;
	}
	// public int getAmount() {
	// 	return Amount;
	// }
	// public void setAmount(int amount) {
	// 	Amount = amount;
	// }
	public int getTherapyDuration() {
		return TherapyDuration;
	}
	public void setTherapyDuration(int therapyDuration) {
		TherapyDuration = therapyDuration;
	}

	public EPrescriptionStatus getStatus() {
		return Status;
	}
	public void setStatus(EPrescriptionStatus status) {
		Status = status;
	}

	public void setTherapyDuration(Integer therapyDuration) {
		TherapyDuration = therapyDuration;
	}

	public Pharmacy getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}

	public EPrescription(Long code, Date issuingDate, Medicine medicine,
			Integer therapyDuration, EPrescriptionStatus status,
		Pharmacy pharmacy) {
		Code = code;
		IssuingDate = issuingDate;
		//Medicine = medicine;
		TherapyDuration = therapyDuration;
		Status = status;
		Pharmacy = pharmacy;
	}
	
}
