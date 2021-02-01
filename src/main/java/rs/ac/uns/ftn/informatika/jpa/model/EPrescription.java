package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;
import java.util.Date;

public class EPrescription {
	private String Code;
	private Date IssuingDate ;
	private Patient Patient;
	private ArrayList<Therapy> Therapies;
	
	public EPrescription(String code, Date issuingDate, rs.ac.uns.ftn.informatika.jpa.model.Patient patient,
			ArrayList<Therapy> therapies) {
		super();
		Code = code;
		IssuingDate = issuingDate;
		Patient = patient;
		Therapies = therapies;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
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

	public ArrayList<Therapy> getTherapies() {
		return Therapies;
	}

	public void setTherapies(ArrayList<Therapy> therapies) {
		Therapies = therapies;
	}

}
