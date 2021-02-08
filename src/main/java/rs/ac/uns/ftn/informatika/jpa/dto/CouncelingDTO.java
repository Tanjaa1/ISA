package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.Counseling;

public class CouncelingDTO {
 
	private Long Id;
	private String Report;
	private LocalDateTime StartTime;
	private Boolean isDone;
	private PatientDTO Patient;
	private PharmacistDTO Pharmacist;
	private PharmacyDTO Pharmacy;
	
	public CouncelingDTO(){}

	public CouncelingDTO(long id, String report, LocalDateTime startTime, Boolean isDone, PatientDTO patient,
		PharmacistDTO pharmacist, PharmacyDTO pharmacy) {
		super();
		this.Id = id;
		Report = report;
		StartTime = startTime;
		this.isDone = isDone;
		Patient = patient;
		Pharmacist = pharmacist;
        Pharmacy = pharmacy;
	}

    public CouncelingDTO(Counseling counceling){
        Id = counceling.getId();
        Report = counceling.getReport();
        StartTime = counceling.getStartTime();
        isDone = counceling.getIsDone();
        Patient = new PatientDTO(counceling.getPatient());
        Pharmacist = new PharmacistDTO(counceling.getPharmacist());
        Pharmacy = new PharmacyDTO(counceling.getPharmacy());
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
}
