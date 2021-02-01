package rs.ac.uns.ftn.informatika.jpa.model;

public class MedicineQuantity {
	private long id;
	private Medicine Medicine;
	private int Quantity;
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public MedicineQuantity(long id, rs.ac.uns.ftn.informatika.jpa.model.Medicine medicine, int quantity) {
		super();
		this.id = id;
		Medicine = medicine;
		Quantity = quantity;
	}
}
