package rs.ac.uns.ftn.informatika.jpa.util;

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

import org.apache.catalina.User;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

@Entity
@Table(name="VacationInterval")
public class VacationInterval {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="DateStart", unique=false, nullable=true)
	private Date DateStart;
	
	@Column(name="DateEnd", unique=false, nullable=true)
	private Date DateEnd ;
	
	@Column(name="Approved", unique=false, nullable=true)
	private Boolean Approved;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Dermatologist Dermatologist;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Pharmacist Pharmacist;
	
	public VacationInterval(){}

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
