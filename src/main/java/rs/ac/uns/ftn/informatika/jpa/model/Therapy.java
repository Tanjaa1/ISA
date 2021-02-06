package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Therapy")
public class Therapy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Medicine_id", referencedColumnName = "Id")
	private Medicine Medicine;
	
	@Column(name="Amount", unique=false, nullable=true)
	private Integer Amount;
	
	@Column(name="TherapyDuration", unique=false, nullable=true)
	private Integer TherapyDuration;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private EPrescription EPrescription;
	
	public Therapy(){}

	public Therapy(long id, rs.ac.uns.ftn.informatika.jpa.model.Medicine medicine, int amount, int therapyDuration) {
		super();
		this.id = id;
		Medicine = medicine;
		Amount = amount;
		TherapyDuration = therapyDuration;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Medicine getMedicine() {
		return Medicine;
	}
	public void setMedicine(Medicine medicine) {
		Medicine = medicine;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getTherapyDuration() {
		return TherapyDuration;
	}
	public void setTherapyDuration(int therapyDuration) {
		TherapyDuration = therapyDuration;
	}
}
