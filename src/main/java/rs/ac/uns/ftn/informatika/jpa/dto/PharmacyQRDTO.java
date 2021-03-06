package rs.ac.uns.ftn.informatika.jpa.dto;


public class PharmacyQRDTO {
    private Long Id;
	private String Name;
	private String Address;
	private Double Grade;
    private Double PriceofMedicines;  
    private Double PriceofMedicinesWithDiscount;

    public PharmacyQRDTO(Long id, String name, String address, Double grade, Double priceofMedicines,Double priceWithDiscount) {
        Id = id;
        Name = name;
        Address = address;
        Grade = grade;
        PriceofMedicines = priceofMedicines;
        PriceofMedicinesWithDiscount=priceWithDiscount;
    }

    public PharmacyQRDTO(PharmacyDTO pharmacistDTO, Double priceofMedicines,Double priceWithDiscount) {
        Id = pharmacistDTO.getId();
        Name = pharmacistDTO.getName();
        Address = pharmacistDTO.getAddress();
        Grade = pharmacistDTO.getGrade();
        PriceofMedicines = priceofMedicines;
        PriceofMedicinesWithDiscount=priceWithDiscount;

    }
    
    public PharmacyQRDTO(){}

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double grade) {
        Grade = grade;
    }

    public Double getPriceofMedicines() {
        return PriceofMedicines;
    }

    public void setPriceofMedicines(Double priceofMedicines) {
        PriceofMedicines = priceofMedicines;
    }
    public Double getPriceofMedicinesWithDiscount() {
        return PriceofMedicinesWithDiscount;
    }
    public void setPriceofMedicinesWithDiscount(Double priceofMedicinesWithDiscount) {
        PriceofMedicinesWithDiscount = priceofMedicinesWithDiscount;
    }

    

}
