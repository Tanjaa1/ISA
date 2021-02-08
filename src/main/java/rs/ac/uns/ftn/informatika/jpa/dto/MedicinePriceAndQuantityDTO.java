package rs.ac.uns.ftn.informatika.jpa.dto;


import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;

public class MedicinePriceAndQuantityDTO {

	private Long Id;
	private MedicineDTO Medicine;
	private Double Price;
	private Integer Quantity;

	public MedicinePriceAndQuantityDTO(){}

	public MedicinePriceAndQuantityDTO(long id,MedicineDTO medicine, double price,int quantity) {

		super();
		this.Id = id;
		Medicine = medicine;
		Price = price;
		Quantity=quantity;
	}

    public MedicinePriceAndQuantityDTO(MedicinePriceAndQuantity medicinePriceAndQuantity){
  		  super();
        Id = medicinePriceAndQuantity.getId();
        Medicine = new MedicineDTO(medicinePriceAndQuantity.getMedicine());
        Price = medicinePriceAndQuantity.getPrice();
        Quantity = medicinePriceAndQuantity.getQuantity();
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
