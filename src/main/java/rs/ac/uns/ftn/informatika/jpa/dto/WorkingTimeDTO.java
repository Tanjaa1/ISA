package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

public class WorkingTimeDTO {

	private long id;

	private LocalDateTime TimeStart;

	private LocalDateTime TimeEnd;
	
	private PharmacyDTO Pharmacy;
	
	public WorkingTimeDTO(){}

	public WorkingTimeDTO(long id, LocalDateTime timeStart, LocalDateTime timeEnd ,PharmacyDTO pharmacy) {
		super();
		this.id = id;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
		Pharmacy = pharmacy;
	}

    public WorkingTimeDTO(WorkingTime WorkingTime) {
		super();
		this.id = WorkingTime.getId();
		TimeStart = WorkingTime.getTimeStart();
		TimeEnd = WorkingTime.getTimeEnd();
		Pharmacy = new PharmacyDTO(WorkingTime.getPharmacy());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PharmacyDTO getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(PharmacyDTO pharmacy) {
		this.Pharmacy = pharmacy;
	}


	public LocalDateTime getTimeStart() {
		return TimeStart;
	}

	public void setTimeStart(LocalDateTime timeStart) {
		TimeStart = timeStart;
	}

	public LocalDateTime getTimeEnd() {
		return TimeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		TimeEnd = timeEnd;
	}

	
}
