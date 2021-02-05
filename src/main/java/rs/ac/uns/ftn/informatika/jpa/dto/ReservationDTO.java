package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public class ReservationDTO {
    private Long Id;
    private Date ExpirationDate;
    private Boolean IsReceived;
    private Long MedicinePriceAndQuantityId;

    public ReservationDTO(){}
    public ReservationDTO(Reservation reservation)
    {
        Id=reservation.getId();
        ExpirationDate=reservation.getExpirationDate();
        IsReceived=reservation.getIsReceived();
        MedicinePriceAndQuantityId=reservation.getMedicine().getId();
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
    public long getMedicinePriceAndQuantityId() {
		return MedicinePriceAndQuantityId;
	}
	public void setMedicinePriceAndQuantityId(long medicinePriceAndQuantityId) {
		MedicinePriceAndQuantityId = medicinePriceAndQuantityId;
	}
}
