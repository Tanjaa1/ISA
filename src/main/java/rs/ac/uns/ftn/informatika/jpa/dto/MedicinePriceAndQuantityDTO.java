package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;


public class MedicinePriceAndQuantityDTO {

    private Long Id;
	private Medicine Medicine;
    private Double Price;
    private Integer Quantity;

	public MedicinePriceAndQuantityDTO(long id,Medicine medicine, double price,int quantity) {
		super();
		this.Id = id;
		Medicine = medicine;
		Price = price;
		Quantity=quantity;
	}

	public MedicinePriceAndQuantityDTO(MedicinePriceAndQuantity medicine) {
		super();
		this.Id = medicine.getId();
		Medicine = medicine.getMedicine();
		Quantity=medicine.getQuantity();
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
