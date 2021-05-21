package rs.ac.uns.ftn.informatika.jpa.dto;

import com.fasterxml.jackson.core.sym.Name;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public class MedicineForQRDTO {
    private Long Id;
	private String Name;
	private String Pharmacy;
    private Integer Quantity;
    public MedicineForQRDTO(Long id, String name, String pharmacy, Integer quantity) {
        Id = id;
        Name = name;
        Pharmacy = pharmacy;
        Quantity = quantity;
    }
    public MedicineForQRDTO(){}
    public MedicineForQRDTO(Medicine m,String pharmacyName,Integer quantity){
        Id=m.getId();
        Name=m.getName();
        Pharmacy=pharmacyName;
        Quantity=quantity;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getPharmacy() {
        return Pharmacy;
    }
    public void setPharmacy(String pharmacy) {
        Pharmacy = pharmacy;
    }
    public Integer getQuantity() {
        return Quantity;
    }
    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
    
	
}
