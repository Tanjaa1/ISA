package rs.ac.uns.ftn.informatika.jpa.util;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.WorkingTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

@Entity
@Table(name="WorkingTime")
public class WorkingTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TimeStart", unique=false, nullable=true)
	private LocalDateTime TimeStart;
	
	@Column(name="TimeEnd", unique=false, nullable=true)
	private LocalDateTime TimeEnd;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Pharmacy Pharmacy;

	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Dermatologist Dermatologist;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Pharmacist Pharmacist;
	
	public WorkingTime(){}

	public WorkingTime(long id, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.id = id;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
	}

	public WorkingTime(WorkingTimeDTO wt) {
		super();
		this.id = wt.getId();
		TimeStart = wt.getTimeStart();
		TimeEnd = wt.getTimeEnd();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Pharmacy getPharmacy(){
		return Pharmacy;
	}

	public void setPharmacy (Pharmacy pharmacy){
		 Pharmacy  = pharmacy;
	}
	

}
