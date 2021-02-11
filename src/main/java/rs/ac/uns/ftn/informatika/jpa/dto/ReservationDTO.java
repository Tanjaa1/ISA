package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public class ReservationDTO {
    private Long Id;
    private Date ExpirationDate;
    private Boolean IsReceived;
    private MedicinePriceAndQuantityDTO MedicinePriceAndQuantityId;
    private PatientDTO Patient;
	private PharmacyDTO Pharmacy;
	private Boolean IsCanceled;

    public ReservationDTO(){}
    public ReservationDTO(Reservation reservation)
    {
        Id=reservation.getId();
        ExpirationDate=reservation.getExpirationDate();
        IsReceived=reservation.getIsReceived();
        MedicinePriceAndQuantityId= new MedicinePriceAndQuantityDTO(reservation.getMedicine());
		Patient= new PatientDTO(reservation.getPatient());
		Pharmacy= new PharmacyDTO(reservation.getPharmacy());
		IsCanceled = reservation.getIsCanceled();
    }
    public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	public Boolean getIsReceived() {
		return IsReceived;
	}
	public void setIsReceived(Boolean isReceived) {
		IsReceived = isReceived;
	}
    public MedicinePriceAndQuantityDTO getMedicinePriceAndQuantityId() {
		return MedicinePriceAndQuantityId;
	}
	public void setMedicinePriceAndQuantityId(MedicinePriceAndQuantityDTO medicinePriceAndQuantityId) {
		MedicinePriceAndQuantityId = medicinePriceAndQuantityId;
	}

	public PatientDTO getPatient(){
		return Patient;
	}
	public void setPatient(PatientDTO patient){
		Patient=patient;
	}
	public PharmacyDTO getPharmacy(){
		return Pharmacy;
	}
	public void setPharmacy(PharmacyDTO pharmacy){
		Pharmacy=pharmacy;
	}

	public Boolean getIsCanceled(){
		return IsCanceled;
	}
	public void setIsCanceled(Boolean isCanceled){
		IsCanceled = isCanceled;
	}
}
