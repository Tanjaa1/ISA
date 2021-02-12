package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Penaltys")
public class Penaltys {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

    @Column(name="PenaltyNumber", unique=false, nullable=true)
    private Integer PenaltyNumber;

    @Column(name="ReservationId", unique=false, nullable=true)
    private Long Reservation;

    @Column(name="IsDeleted", unique=false, nullable=true)
    private Boolean IsDeleted;

    public Penaltys(){}

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
