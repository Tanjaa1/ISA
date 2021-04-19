package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;

@Entity
@Table(name="ActionOrPromotion")
public class ActionOrPromotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;
	
	@Column(name="StartTime", unique=false, nullable=true)
	private LocalDateTime StartTime;

	@Column(name="EndTime", unique=false, nullable=true)
	private LocalDateTime EndTime;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 private Pharmacy Pharmacy;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Medicine Medicine;
	
	public ActionOrPromotion(){}

	public ActionOrPromotion(long id, String text, Pharmacy pharmacy, Medicine medicine,LocalDateTime startTime,LocalDateTime endTime) {
		super();
		Id = id;
		Text = text;
		Pharmacy = pharmacy;
		Medicine = medicine;
		StartTime = startTime;
		EndTime = endTime;
	}
	public ActionOrPromotion(ActionOrPromotionsDTO a){
		Id=a.getId();
		Text=a.getText();
		Pharmacy=new Pharmacy(a.getPharmacy());
		Medicine=new Medicine(a.getMedicine());
		StartTime=a.getStartTime();
		EndTime=a.getEndDateTime();

	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	 public Pharmacy getPharmacy() {
	 	return Pharmacy;
	 }
	 public void setPharmacy(Pharmacy pharmacy) {
	 	Pharmacy = pharmacy;
	 }

	 public Medicine getMedicine() {
		return Medicine;
	}
	public void setMedicine(Medicine medicine) {
		Medicine = medicine;
	}

	public LocalDateTime getStartTime() {
		return StartTime;
	}
	public void setStartTime(LocalDateTime date) {
		StartTime = date;
	}

	public LocalDateTime getEndTime() {
		return EndTime;
	}
	public void setEndTime(LocalDateTime date) {
		EndTime = date;
	}
}
