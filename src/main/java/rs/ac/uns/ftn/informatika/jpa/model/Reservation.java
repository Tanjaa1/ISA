package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="ExpirationDate", unique=false, nullable=true)
	private Date ExpirationDate;
	
	@Column(name="IsReceived", unique=false, nullable=true)
	private Boolean IsReceived;

	//@JsonManagedReference(value = "reservation_pat")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient Patient;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Medicine_id", referencedColumnName = "id")
	private MedicinePriceAndQuantity Medicine;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;

	@Column(name="IsCanceled", unique=false, nullable=true)
	private Boolean IsCanceled;

	public Reservation(){}
	
	public Reservation(long id, Date expirationDate, Boolean isReceived,
			rs.ac.uns.ftn.informatika.jpa.model.Patient patient, MedicinePriceAndQuantity medicine, Boolean isCanceled) {
		super();
		this.Id = id;
		ExpirationDate = expirationDate;
		IsReceived = isReceived;
		Patient = patient;
		Medicine = medicine;
		IsCanceled = isCanceled;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	public Boolean getIsReceived() {
		return IsReceived;
	}
	public void setIsReceived(Boolean isReceived) {
		IsReceived = isReceived;
	}
	public Patient getPatient() {
		return Patient;
	}
	public void setPatient(Patient patient) {
		Patient = patient;
	}
	public MedicinePriceAndQuantity getMedicine() {
		return Medicine;
	}
	public void setMedicine(MedicinePriceAndQuantity medicine) {
		Medicine = medicine;
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
