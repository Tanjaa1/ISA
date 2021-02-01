package rs.ac.uns.ftn.informatika.jpa.model;

public class MedicinePriceAndQuantity {
	private long id;
	private Medicine Medicine;
	private double Price;
	private int Quantity;
	
	public MedicinePriceAndQuantity(long id,Medicine medicine, double price,int quantity) {
		super();
		this.id = id;
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

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
}
