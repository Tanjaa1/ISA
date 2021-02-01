package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;

public class Reservation {
	private long id;
	private Date ExpirationDate;
	private Boolean IsReceived;
	private Patient Patient;
	private MedicinePriceAndQuantity Medicine;
	
	
	public Reservation(long id, Date expirationDate, Boolean isReceived,
			rs.ac.uns.ftn.informatika.jpa.model.Patient patient, MedicinePriceAndQuantity medicine) {
		super();
		this.id = id;
		ExpirationDate = expirationDate;
		IsReceived = isReceived;
		Patient = patient;
		Medicine = medicine;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	

}
