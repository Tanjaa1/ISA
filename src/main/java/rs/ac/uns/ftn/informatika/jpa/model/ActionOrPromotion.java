package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ActionOrPromotion")
public class ActionOrPromotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 private Pharmacy Pharmacy;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Medicine Medicine;
	
	public ActionOrPromotion(){}

	public ActionOrPromotion(long id, String text, Pharmacy pharmacy, Medicine medicine) {
		super();
		Id = id;
		Text = text;
		Pharmacy = pharmacy;
		Medicine = medicine;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
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
}
