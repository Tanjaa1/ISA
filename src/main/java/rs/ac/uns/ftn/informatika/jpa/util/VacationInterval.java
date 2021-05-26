package rs.ac.uns.ftn.informatika.jpa.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

import rs.ac.uns.ftn.informatika.jpa.dto.VacationIntervalDTO;

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

	@Column(name="PharmacyId",unique=false, nullable=true)
	private Long PharmacyId;
	
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Dermatologist Dermatologist;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Pharmacist Pharmacist;
	
	public VacationInterval(){
		Approved=false;
	}

	public VacationInterval(Long id, Date dateStart, Date dateEnd, Boolean approved, Long p) {
		super();
		Id = id;
		DateStart = dateStart;
		DateEnd = dateEnd;
		Approved = false;
		PharmacyId = p;
	}

	public VacationInterval(VacationIntervalDTO v) {
		super();
		Id = v.getId();
		DateStart = v.getDateStart();
		DateEnd = v.getDateEnd();
		Approved = v.getApproved();
		PharmacyId = v.getPharmacyId();
	}

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
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
	
	public Long getPharmacyId() {
		return PharmacyId;
	}


	public void setPharmacyId(Long pharmacy) {
		PharmacyId = pharmacy;
	}
	
	
}
