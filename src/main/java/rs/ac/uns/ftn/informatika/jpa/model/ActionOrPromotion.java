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
@Table(name="ActionOrPromotion")
public class ActionOrPromotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Text", unique=false, nullable=true)
	private String Text;
	
	// @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id")
	// private Pharmacy Pharmacy;
	
	public ActionOrPromotion(){}

	public ActionOrPromotion(long id, String text/*, rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy*/) {
		super();
		Id = id;
		Text = text;
		//Pharmacy = pharmacy;
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
	// public Pharmacy getPharmacy() {
	// 	return Pharmacy;
	// }
	// public void setPharmacy(Pharmacy pharmacy) {
	// 	Pharmacy = pharmacy;
	// }
}
