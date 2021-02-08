package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.enums.EPrescriptionStatus;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class EPrescriptionDTO {
    private MedicinePriceAndQuantityDTO Medicine;
    private Date IssuingDate;
    private Integer TherapyDuration;
	private EPrescriptionStatus Status; 
	private Pharmacy Pharmacy;

	public EPrescriptionDTO(EPrescription ePrescription){
		Medicine = new MedicinePriceAndQuantityDTO(ePrescription.getMedicine());
		IssuingDate = ePrescription.getIssuingDate();
		TherapyDuration = ePrescription.getTherapyDuration();
		Status = ePrescription.getStatus();
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

    public MedicinePriceAndQuantityDTO getMedicine() {
		return Medicine;
	}

	public void setMedicine(MedicinePriceAndQuantityDTO medicine) {
		Medicine = medicine;
	}

    public Date getIssuingDate() {
		return IssuingDate;
	}

	public void setIssuingDate(Date issuingDate) {
		IssuingDate = issuingDate;
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
	
	public EPrescriptionDTO(EPrescription ePrescription){
        Medicine = ePrescription.getMedicine();
        IssuingDate = ePrescription.getIssuingDate();
        TherapyDuration = ePrescription.getTherapyDuration();
        Status = ePrescription.getStatus();
		Pharmacy=ePrescription.getPharmacy();
    }
	
}
