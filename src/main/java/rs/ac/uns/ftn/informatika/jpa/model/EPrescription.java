package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EPrescription")
public class EPrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Code;
	
	@Column(name="IssuingDate", unique=false, nullable=true)
	private Date IssuingDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient Patient;
	
	@OneToMany(mappedBy = "EPrescription", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Therapy> Therapies = new HashSet<>();
	
	public EPrescription(Long code, Date issuingDate, rs.ac.uns.ftn.informatika.jpa.model.Patient patient,
			Set<Therapy> therapies) {
		super();
		Code = code;
		IssuingDate = issuingDate;
		Patient = patient;
		Therapies = therapies;
	}

	public Long getCode() {
		return Code;
	}

	public void setCode(Long code) {
		Code = code;
	}

	public Date getIssuingDate() {
		return IssuingDate;
	}

	public void setIssuingDate(Date issuingDate) {
		IssuingDate = issuingDate;
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	public Set<Therapy> getTherapies() {
		return Therapies;
	}

	public void setTherapies(Set<Therapy> therapies) {
		Therapies = therapies;
	}

}
