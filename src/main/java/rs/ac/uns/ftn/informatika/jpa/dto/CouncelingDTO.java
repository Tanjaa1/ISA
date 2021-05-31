package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;


import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

public class CouncelingDTO {
 
	private Long Id;
	private String Report;
	private LocalDateTime StartTime;
	private LocalDateTime EndTime;
	private Boolean isDone;
	private PatientDTO Patient;
	private PharmacistDTO Pharmacist;
	private PharmacyDTO Pharmacy;
	private Double Price;
	private Double PriceWithDiscount;
	private Boolean IsCanceled;
	
	public CouncelingDTO(){}
/*
	public CouncelingDTO(long id, String report, LocalDateTime startTime, LocalDateTime endTime, Boolean isDone, PatientDTO patient,
		PharmacistDTO pharmacist, PharmacyDTO pharmacy,Double price, Boolean isCanceled) {
		super();
		this.Id = id;
		Report = report;
		StartTime = startTime;
		EndTime = endTime;
		this.isDone = isDone;
		Patient = patient;
		Pharmacist = pharmacist;
        Pharmacy = pharmacy;
		Price=price;
		IsCanceled = isCanceled;
	}

*/	public CouncelingDTO(long id, String report, LocalDateTime startTime, LocalDateTime endTime, Boolean isDone, PatientDTO patient,
		PharmacistDTO pharmacist, PharmacyDTO pharmacy,Double price, Boolean isCanceled,Double priceWitDiscount) {
		super();
		this.Id = id;
		Report = report;
		StartTime = startTime;
		EndTime = endTime;
		this.isDone = isDone;
		Patient = patient;
		Pharmacist = pharmacist;
        Pharmacy = pharmacy;
		Price=price;
		IsCanceled = isCanceled;
		PriceWithDiscount=priceWitDiscount;
	}

    public CouncelingDTO(Counseling counceling){
        Id = counceling.getId();
        Report = counceling.getReport();
        StartTime = counceling.getStartTime();
        EndTime = counceling.getEndTime();
        isDone = counceling.getIsDone();
		if(counceling.getPatient() != null)
        	Patient = new PatientDTO(counceling.getPatient());
		else
        	Patient = new PatientDTO();
        Pharmacist = new PharmacistDTO(counceling.getPharmacist());
        Pharmacy = new PharmacyDTO(counceling.getPharmacy());
		Price=counceling.getPrice();
		IsCanceled = counceling.getIsCanceled();
    }

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public LocalDateTime getStartTime() {
		return StartTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		StartTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return EndTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		EndTime = endTime;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public PatientDTO getPatient() {
		return Patient;
	}

	public void setPatient(PatientDTO patient) {
		Patient = patient;
	}

	public PharmacistDTO getPharmacist() {
		return Pharmacist;
	}

	public void setPharmacist(PharmacistDTO pharmacist) {
		Pharmacist = pharmacist;
	}

	public PharmacyDTO getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(PharmacyDTO pharmacy) {
		Pharmacy = pharmacy;
	}
		
	public Double getPrice(){
		return Price;
	}

	public void setPrice(Double price){
		Price=price;
	}

	public Boolean getIsCanceled(){
		return IsCanceled;
	}

	public void setIsCanceled(Boolean isCanceled){
		IsCanceled=isCanceled;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Double getPriceWithDiscount() {
		return PriceWithDiscount;
	}

	public void setPriceWithDiscount(Double priceWithDiscount) {
		PriceWithDiscount = priceWithDiscount;
	}
	
}
