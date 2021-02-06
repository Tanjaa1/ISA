package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Medicine_code", referencedColumnName = "code")
	private Medicine Medicine;
	
	// @Column(name="Amount", unique=false, nullable=true)
	// private Integer Amount;
	
	@Column(name="TherapyDuration", unique=false, nullable=true)
	private Integer TherapyDuration;
	
	
	@Column(name="Status", unique=false, nullable=true)
	private EPrescriptionStatus Status; 

	public EPrescription(){
		Status= EPrescriptionStatus.New;
	}

	public EPrescription(Long code, Date issuingDate/*, rs.ac.uns.ftn.informatika.jpa.model.Patient patient*/) {
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

	// public Therapy getTherapies() {
	// 	return Therapy;
	// }

	// public void setTherapies(Set<Therapy> therapies) {
	// 	Therapies = therapies;
	// }
	public Medicine getMedicine() {
		return Medicine;
	}
	public void setMedicine(Medicine medicine) {
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
}
