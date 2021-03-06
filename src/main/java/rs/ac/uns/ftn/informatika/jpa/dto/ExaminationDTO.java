package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public class ExaminationDTO {

	private Long Id;
	private String Report;
	private LocalDateTime StartTime;
	private LocalDateTime EndTime;
	private Boolean isDone;
	private PatientDTO Patient;
	private DermatologistDTO Dermatologist;
	private PharmacyDTO Pharmacy;
	private Double Price;
	private Double PriceWithDiscount;

	private Boolean IsCanceled;
	
	public ExaminationDTO(){}

	public ExaminationDTO(long id, String report, LocalDateTime startTime,LocalDateTime endTime, Boolean isDone, PatientDTO patient,
			DermatologistDTO dermatologist, PharmacyDTO pharmacy,Double price, Boolean isCanceled) {
		super();
		Id = id;
		Report = report;
		StartTime = startTime;
		EndTime = endTime;
		this.isDone = isDone;
		Patient = patient;
		Dermatologist = dermatologist;
		Pharmacy = pharmacy;
		Price=price;
		IsCanceled = isCanceled;
	}

	
	public ExaminationDTO(long id, String report, LocalDateTime startTime,LocalDateTime endTime, Boolean isDone, PatientDTO patient,
			DermatologistDTO dermatologist, PharmacyDTO pharmacy,Double price, Boolean isCanceled,Double priceWithDiscount) {
		super();
		Id = id;
		Report = report;
		StartTime = startTime;
		EndTime = endTime;
		this.isDone = isDone;
		Patient = patient;
		Dermatologist = dermatologist;
		Pharmacy = pharmacy;
		Price=price;
		IsCanceled = isCanceled;
		PriceWithDiscount=priceWithDiscount;
	}

    public ExaminationDTO(Examination examination){
        Id = examination.getId();
        Report = examination.getReport();
        StartTime = examination.getStartTime();
        EndTime = examination.getEndTime();
        isDone = examination.getIsDone();
		if(examination.getPatient()==null)
			Patient=new PatientDTO();
		else
        	Patient = new PatientDTO(examination.getPatient());
		if(examination.getDermatologist()!=null)
       		Dermatologist = new DermatologistDTO(examination.getDermatologist());
		else
			Dermatologist = new DermatologistDTO();
		if(examination.getPharmacy()!=null)
        	Pharmacy = new PharmacyDTO(examination.getPharmacy());
		else
			Pharmacy = new PharmacyDTO();
		Price=examination.getPrice();
		IsCanceled = examination.getIsCanceled();
		PriceWithDiscount=examination.getPriceWithDiscount();
    }

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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
	
	public Double getPrice(){
		return Price;
	}

	public void setPrice(Double price){
		Price=price;
	}

	public Boolean getIsCanceled() {
		return IsCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.IsCanceled = isCanceled;
	}

	public Double getPriceWithDiscount() {
		return PriceWithDiscount;
	}

	public void setPriceWithDiscount(Double priceWithDiscount) {
		PriceWithDiscount = priceWithDiscount;
	}
	
}
