package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public class ExaminationDTO {

	private Long Id;
	private String Report;
	private LocalDateTime StartTime;
	private Boolean isDone;
	private PatientDTO Patient;
	private DermatologistDTO Dermatologist;
	private PharmacyDTO Pharmacy;
	
	public ExaminationDTO(){}

	public ExaminationDTO(long id, String report, LocalDateTime startTime, Boolean isDone, PatientDTO patient,
			DermatologistDTO dermatologist, PharmacyDTO pharmacy) {
		super();
		Id = id;
		Report = report;
		StartTime = startTime;
		this.isDone = isDone;
		Patient = patient;
		Dermatologist = dermatologist;
		Pharmacy = pharmacy;
	}

    public ExaminationDTO(Examination examination){
        Id = examination.getId();
        Report = examination.getReport();
        StartTime = examination.getStartTime();
        isDone = examination.getIsDone();
        Patient = new PatientDTO(examination.getPatient());
        Dermatologist = new DermatologistDTO(examination.getDermatologist());
        Pharmacy = new PharmacyDTO(examination.getPharmacy());
    }

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public DermatologistDTO getDermatologist() {
		return Dermatologist;
	}

	public void setDermatologist(DermatologistDTO dermatologist) {
		Dermatologist = dermatologist;
	}

	public PharmacyDTO getPharmacy() {
		return Pharmacy;
	}

	public void setPharmacy(PharmacyDTO pharmacy) {
		Pharmacy = pharmacy;
	}
	
}
