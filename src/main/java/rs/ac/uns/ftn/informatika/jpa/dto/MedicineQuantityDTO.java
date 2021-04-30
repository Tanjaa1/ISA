package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineQuantity;

public class MedicineQuantityDTO {
	private Long Id;
	private MedicineDTO Medicines;
	private Integer Quantity;
    public MedicineQuantityDTO(Long id, MedicineDTO medicine, Integer quantity) {
        Id = id;
        Medicines = medicine;
        Quantity = quantity;
    }
    public MedicineQuantityDTO(MedicineQuantity m) {
        Id = m.getId();
        Medicines = new MedicineDTO(m.getMedicine());
        Quantity = m.getQuantity();
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public MedicineDTO getMedicine() {
        return Medicines;
    }
    public void setMedicine(MedicineDTO medicine) {
        Medicines = medicine;
    }
    public Integer getQuantity() {
        return Quantity;
    }
    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }


    
}
