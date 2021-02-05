package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public class ReservationDTO {
    private Long Id;
    private Date ExpirationDate;
    private Boolean IsReceived;
    private MedicinePriceAndQuantity MedicinePriceAndQuantityId;
    private String Patient;
	private Long Pharmacy;

    public ReservationDTO(){}
    public ReservationDTO(Reservation reservation)
    {
        Id=reservation.getId();
        ExpirationDate=reservation.getExpirationDate();
        IsReceived=reservation.getIsReceived();
        MedicinePriceAndQuantityId=reservation.getMedicine();
		Patient=reservation.getPatient().getFullName();
		Pharmacy=reservation.getPharmacy().getId();
    }
    public long getId() {
		return Id;
	}
	public void setId(long id) {
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
    public MedicinePriceAndQuantity getMedicinePriceAndQuantityId() {
		return MedicinePriceAndQuantityId;
	}
	public void setMedicinePriceAndQuantityId(MedicinePriceAndQuantity medicinePriceAndQuantityId) {
		MedicinePriceAndQuantityId = medicinePriceAndQuantityId;
	}

	public String getPatient(){
		return Patient;
	}
	public void setPatient(String patient){
		Patient=patient;
	}
	public Long getPharmacy(){
		return Pharmacy;
	}
	public void setPharmacy(Long pharmacy){
		Pharmacy=pharmacy;
	}
}
