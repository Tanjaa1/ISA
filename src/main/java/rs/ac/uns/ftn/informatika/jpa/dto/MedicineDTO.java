package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public class MedicineDTO {

	private Long Code;
	private String Name;
	private String Type;
	private MedicineForm Form;
	private String Composition;
	private String Manufacturer;
	private Boolean OnPrescription;
	private Set<String> Replacement = new HashSet<String>();
	private String Note;
	
	//@OneToOne(mappedBy = "Medicine")
    //private MedicinePriceAndQuantity MedicinePriceAndQuantity;
	
	public MedicineDTO(){}

	public MedicineDTO(long code, String name, String type, MedicineForm form, String composition, String manufacturer,
			Boolean onPrescription, Set<String> replacement, String note) {
		super();
		Code = code;
		Name = name;
		Type = type;
		Form = form;
		Composition = composition;
		Manufacturer = manufacturer;
		OnPrescription = onPrescription;
		Replacement = replacement;
		Note = note;
	}

    public MedicineDTO(Medicine medicine){
        Code = medicine.getCode();
        Name = medicine.getName();
        Type = medicine.getType();
        Form = medicine.getForm();
        Composition = medicine.getComposition();
        Manufacturer = medicine.getManufacturer();
        OnPrescription = medicine.getOnPrescription();
        Replacement = medicine.getReplacement();
        Note = medicine.getNote();
    }

	public long getCode() {
		return Code;
	}

	public void setCode(long code) {
		Code = code;
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

	public MedicineForm getForm() {
		return Form;
	}

	public void setForm(MedicineForm form) {
		Form = form;
	}

	public String getComposition() {
		return Composition;
	}

	public void setComposition(String composition) {
		Composition = composition;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public Boolean getOnPrescription() {
		return OnPrescription;
	}

	public void setOnPrescription(Boolean onPrescription) {
		OnPrescription = onPrescription;
	}

	public Set<String> getReplacement() {
		return Replacement;
	}

	public void setReplacement(Set<String> replacement) {
		Replacement = replacement;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}
}
