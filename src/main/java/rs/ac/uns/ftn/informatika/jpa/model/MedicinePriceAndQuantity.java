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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;

@Entity
@Table(name="MedicinePriceAndQuantity")
public class MedicinePriceAndQuantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "Medicine_id", referencedColumnName = "Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Medicine Medicine;
	
	@Column(name="Price", unique=false, nullable=true)
	private Double Price;
	
	@Column(name="Quantity", unique=false, nullable=true)
	private Integer Quantity;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Pharmacy Pharmacy;
	
	public MedicinePriceAndQuantity(){
		Medicine=new Medicine();
		Price=0.00;
		Quantity=0;
	}

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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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

	public MedicinePriceAndQuantity(MedicinePriceAndQuantityDTO medicinePriceAndQuantity){
		super();
	Id = medicinePriceAndQuantity.getId();
	Medicine = new Medicine(medicinePriceAndQuantity.getMedicine());
	Price = medicinePriceAndQuantity.getPrice();
	Quantity = medicinePriceAndQuantity.getQuantity();
}

	
}
