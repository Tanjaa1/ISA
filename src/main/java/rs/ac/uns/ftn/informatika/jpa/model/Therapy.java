package rs.ac.uns.ftn.informatika.jpa.model;

public class Therapy {
	private long id;
	private Medicine Medicine;
	private int Amount;
	private int TherapyDuration;
	
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
