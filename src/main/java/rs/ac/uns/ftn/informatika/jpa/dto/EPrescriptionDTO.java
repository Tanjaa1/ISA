package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.enums.EPrescriptionStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public class EPrescriptionDTO {
    private Medicine Medicine;
    private Date IssuingDate;
    private Integer TherapyDuration;
	private EPrescriptionStatus Status; 

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

    public Medicine getMedicine() {
		return Medicine;
	}

	public void setMedicine(Medicine medicine) {
		Medicine = medicine;
	}

    public Date getIssuingDate() {
		return IssuingDate;
	}

	public void setIssuingDate(Date issuingDate) {
		IssuingDate = issuingDate;
	}
}
