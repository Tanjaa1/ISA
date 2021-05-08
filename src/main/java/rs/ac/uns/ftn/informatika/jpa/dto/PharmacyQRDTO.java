package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Set;

public class PharmacyQRDTO {
    private Long Id;
	private String Name;
	private String Address;
	private Integer Grade;
    private Double PriceofMedicines;
    public PharmacyQRDTO(Long id, String name, String address, Integer grade, Double priceofMedicines) {
        Id = id;
        Name = name;
        Address = address;
        Grade = grade;
        PriceofMedicines = priceofMedicines;
    }
    public PharmacyQRDTO(PharmacyDTO pharmacistDTO, Double priceofMedicines) {
        Id = pharmacistDTO.getId();
        Name = pharmacistDTO.getName();
        Address = pharmacistDTO.getAddress();
        Grade = pharmacistDTO.getGrade();
        PriceofMedicines = priceofMedicines;
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

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
    }

    public Double getPriceofMedicines() {
        return PriceofMedicines;
    }

    public void setPriceofMedicines(Double priceofMedicines) {
        PriceofMedicines = priceofMedicines;
    }

    

}
