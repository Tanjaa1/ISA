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
import rs.ac.uns.ftn.informatika.jpa.validator.CustomAnnotation;

@Entity
@Table(name="EPrescription")
public class EPrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Code;
	
	@Column(name="IssuingDate", unique=false, nullable=true)
	private Date IssuingDate;
	
    @CustomAnnotation(message = "Medicine is mandatory")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private MedicinePriceAndQuantity Medicine;
	
	@Column(name="TherapyDuration", unique=false, nullable=true)
	private Integer TherapyDuration;
	
	
	@Column(name="Status", unique=false, nullable=true)
	private EPrescriptionStatus Status; 
	
    @CustomAnnotation(message = "Pharmacy is mandatory")
	@ManyToOne
	(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pharmacy Pharmacy;

	public EPrescription(){
		Status= EPrescriptionStatus.New;
		Pharmacy=new Pharmacy();
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

	public MedicinePriceAndQuantity getMedicine() {
		return Medicine;
	}
	public void setMedicine(MedicinePriceAndQuantity medicine) {
		Medicine = medicine;
	}

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
		TherapyDuration = therapyDuration;
		Status = status;
		Pharmacy = pharmacy;
	}
	
}
