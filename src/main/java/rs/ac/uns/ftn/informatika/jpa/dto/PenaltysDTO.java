package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;

public class PenaltysDTO {
 
	private Long Id;
    private Integer PenaltyNumber;
    private Long Reservation;
	private Boolean IsDeleted;

    public PenaltysDTO(){}

    public PenaltysDTO(Penaltys penaltys){
        Id = penaltys.getId();
        PenaltyNumber = penaltys.getPenaltyNumber();
        Reservation = penaltys.getReservation();
		IsDeleted = penaltys.getIsDeleted();
    }

    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
    public Integer getPenaltyNumber() {
		return PenaltyNumber;
	}

	public void setPenaltyNymber(Integer penaltyNumber) {
		PenaltyNumber = penaltyNumber;
	}
    public Long getReservation() {
		return Reservation;
	}

	public void setReservation(Long reservation) {
		Reservation = reservation;
	}

	public Boolean getIsDeleted() {
		return IsDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		IsDeleted = isDeleted;
	}

}
