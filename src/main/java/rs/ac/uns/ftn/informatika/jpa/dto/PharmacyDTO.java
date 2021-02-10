package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;


import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class PharmacyDTO {
    private Long Id;
	private String Name;
	private String Address;
	private Integer Grade;
	public Set<ActionOrPromotionsDTO> ListActionsOrPromotions = new HashSet<ActionOrPromotionsDTO>();
	private Set<MedicinePriceAndQuantityDTO> Pricelist = new HashSet<MedicinePriceAndQuantityDTO>();
    
    public PharmacyDTO(){}

	public PharmacyDTO(long id,String name, String address, Integer grade,Set<MedicinePriceAndQuantityDTO> pricelist) {
		super();
		Id=id;
		Name = name;
		Address = address;
	    Grade = grade;
		Pricelist=pricelist;
    }
    
    public PharmacyDTO(Pharmacy pharmacy) {
		Id=pharmacy.getId();
		Name = pharmacy.getName();
        Address = pharmacy.getAddress();
        double result =  0;
        int i = 0;
        for (Integer m : pharmacy.getMarks()) {
            result += m;
            i++;
        }
		if(i != 0)
        	Grade = (int) Math.round(result / i);
		for (MedicinePriceAndQuantity medicinePriceAndQuantity : pharmacy.getPricelist()) {
			Pricelist.add(new MedicinePriceAndQuantityDTO(medicinePriceAndQuantity));
		}
	}

	public long getId() {
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

	 public Set<MedicinePriceAndQuantityDTO> getPricelist() {
	 	return Pricelist;
	 }

	 public void setPricelist(Set<MedicinePriceAndQuantityDTO> pricelist) {
	 	Pricelist = pricelist;
	 }

}
