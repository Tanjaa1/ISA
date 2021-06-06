package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class PharmacyDTO {
    private Long Id;
	private String Name;
	private String Address;
	private Double Grade;
	private Double CounselingPrice;
	public Set<ActionOrPromotionsDTO> ListActionsOrPromotions = new HashSet<ActionOrPromotionsDTO>();
	private Set<MedicinePriceAndQuantityDTO> Pricelist = new HashSet<MedicinePriceAndQuantityDTO>();
    
    public PharmacyDTO(){}

	public PharmacyDTO(String name) {
		super();
		Name = name;
    }

	public PharmacyDTO(long id,String name, String address, Double grade, Double counselingPrice, Set<MedicinePriceAndQuantityDTO> pricelist) {
		super();
		Id=id;
		Name = name;
		Address = address;
	    Grade = grade;
		CounselingPrice = counselingPrice;
		Pricelist=pricelist;
    }
    
    public PharmacyDTO(Pharmacy pharmacy) {
		Id=pharmacy.getId();
		Name = pharmacy.getName();
        Address = pharmacy.getAddress();
        double result =  0;
        int i = 0;
        for (Markk m : pharmacy.getMarks()) {
            result += m.getMarks();
            i++;
        }
		if(i != 0)
        	Grade = (double) Math.round(result / i * 10) / 10;
		for (MedicinePriceAndQuantity medicinePriceAndQuantity : pharmacy.getPricelist()) {
			Pricelist.add(new MedicinePriceAndQuantityDTO(medicinePriceAndQuantity));
		}
		CounselingPrice = pharmacy.getCounselingPrice();
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

	 public Set<MedicinePriceAndQuantityDTO> getPricelist() {
	 	return Pricelist;
	 }

	 public void setPricelist(Set<MedicinePriceAndQuantityDTO> pricelist) {
	 	Pricelist = pricelist;
	 }

	 public Double getCounselingPrice() {
		return CounselingPrice;
	}

	public void setCounselingPrice(Double counselingPrice) {
		CounselingPrice = counselingPrice;
	}

}
