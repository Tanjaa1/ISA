package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;

public class Medicine {
	private long Code;
	private String Name;
	private String Type;
	private MedicineForm Form;
	private String Composition;
	private String Manufacturer;
	private Boolean OnPrescription;
	private ArrayList<Medicine> Replacement;
	private String Note;
	
	public Medicine(long code, String name, String type, MedicineForm form, String composition, String manufacturer,
			Boolean onPrescription, ArrayList<Medicine> replacement, String note) {
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

	public ArrayList<Medicine> getReplacement() {
		return Replacement;
	}

	public void setReplacement(ArrayList<Medicine> replacement) {
		Replacement = replacement;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}
	

}
