package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MedicinePriceAndQuantity")
public class MedicinePriceAndQuantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Medicine_id", referencedColumnName = "Id")
	private Medicine Medicine;
	
	@Column(name="Price", unique=false, nullable=true)
	private Double Price;
	
	@Column(name="Quantity", unique=false, nullable=true)
	private Integer Quantity;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Pharmacy Pharmacy;
	
	public MedicinePriceAndQuantity(){}

	public MedicinePriceAndQuantity(long id,Medicine medicine, double price,int quantity) {
		super();
		this.Id = id;
		Medicine = medicine;
		Price = price;
		Quantity=quantity;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public Medicine getMedicine() {
		return Medicine;
	}

	public void setMedicine(Medicine medicine) {
		Medicine = medicine;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
}
