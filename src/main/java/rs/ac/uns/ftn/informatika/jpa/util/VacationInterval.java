package rs.ac.uns.ftn.informatika.jpa.util;

import java.util.Date;

public class VacationInterval {
	private long Id;
	private Date DateStart;
	private Date DateEnd ;
	private Boolean Approved;
	
	
	public VacationInterval(long id, Date dateStart, Date dateEnd, Boolean approved) {
		super();
		Id = id;
		DateStart = dateStart;
		DateEnd = dateEnd;
		Approved = false;
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
