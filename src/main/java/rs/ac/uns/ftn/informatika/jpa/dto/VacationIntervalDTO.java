package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

public class VacationIntervalDTO {

	private long Id;
	private Date DateStart;
	private Date DateEnd ;
	private Boolean Approved;
	public VacationIntervalDTO(){}

	public VacationIntervalDTO(long id, Date dateStart, Date dateEnd, Boolean approved) {
		super();
		Id = id;
		DateStart = dateStart;
		DateEnd = dateEnd;
		Approved = false;
	}
   
	public VacationIntervalDTO(VacationInterval vacationInterval) {
		super();
		Id = vacationInterval.getId();
		DateStart = vacationInterval.getDateStart();
		DateEnd = vacationInterval.getDateEnd();
		Approved = vacationInterval.getApproved();
	}

	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public Date getDateStart() {
		return DateStart;
	}


	public void setDateStart(Date dateStart) {
		DateStart = dateStart;
	}


	public Date getDateEnd() {
		return DateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		DateEnd = dateEnd;
	}


	public Boolean getApproved() {
		return Approved;
	}


	public void setApproved(Boolean approved) {
		Approved = approved;
	}
	
}
