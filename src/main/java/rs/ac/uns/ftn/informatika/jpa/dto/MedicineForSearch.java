package rs.ac.uns.ftn.informatika.jpa.dto;

public class MedicineForSearch {
	private String Name;
	private String Type;
	private String Composition;
	private String Pharmacy;
    private String Mark;
    private String Price;
    private String OnPrescription;
    private String Form;

   
  

    public String getOnPrescription() {
        return OnPrescription;
    }

    public void setOnPrescription(String onPrescription) {
        OnPrescription = onPrescription;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String form) {
        Form = form;
    }

    public MedicineForSearch(String name, String type, String composition, String pharmacy, String mark, String price,
            String onPrescription, String form) {
        Name = name;
        Type = type;
        Composition = composition;
        Pharmacy = pharmacy;
        Mark = mark;
        Price = price;
        OnPrescription = onPrescription;
        Form = form;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getComposition() {
        return Composition;
    }

    public void setComposition(String composition) {
        Composition = composition;
    }

    public String getPharmacy() {
        return Pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        Pharmacy = pharmacy;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    

    


    
}
