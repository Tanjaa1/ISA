package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.enums.MedicineType;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public class MedicineDTO {
	private Long Id;
	private String Code;
	private String Name;
	//private String Type;
	private MedicineForm Form;
	private MedicineType Type;
	private String Composition;
	private String Manufacturer;
	private Boolean OnPrescription;
	//private Set<String> Replacement = new HashSet<String>();
	private String Replacement;
	private String Note;
	private String Contraindications;
	private String DailyDose;
	private Integer Grade;
	
	public MedicineDTO(){}

	public MedicineDTO(String code, String name, String type, MedicineForm form, String composition, String manufacturer,
			Boolean onPrescription, Set<String> replacement, String note) {
		super();
		Code = code;
		Name = name;
		//Type = type;
		Form = form;
		Composition = composition;
		Manufacturer = manufacturer;
		OnPrescription = onPrescription;
		//Replacement = replacement;
		Note = note;
	}

	
	
	 public MedicineDTO(Medicine medicine){
			Id = medicine.getId();
	        Code = medicine.getCode();
	        Name = medicine.getName();
	        Type = medicine.getType();
	        Form = medicine.getForm();
	        Composition = medicine.getComposition();
	        Manufacturer = medicine.getManufacturer();
	        OnPrescription = medicine.getOnPrescription();
	       // Replacement = medicine.getReplacement();
	        Note = medicine.getNote();
			double result =  0;
	        int i = 0;
	        for (Markk m : medicine.getMarks()) {
	            result += m.getMarks();
	            i++;
	        }
			if(i != 0)
	        	Grade = (int) Math.round(result / i);
	    }

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
/*
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
*/
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
/*
	public Set<String> getReplacement() {
		return Replacement;
	}

	public void setReplacement(Set<String> replacement) {
		Replacement = replacement;
	}
*/
	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public MedicineType getType() {
		return Type;
	}

	public void setType(MedicineType type) {
		Type = type;
	}

	public String getReplacement() {
		return Replacement;
	}

	public void setReplacement(String replacement) {
		Replacement = replacement;
	}

	public String getContraindications() {
		return Contraindications;
	}

	public void setContraindications(String contraindications) {
		Contraindications = contraindications;
	}

	public String getDailyDose() {
		return DailyDose;
	}

	public void setDailyDose(String dailyDose) {
		DailyDose = dailyDose;
	}

	public MedicineDTO(Long id, String name, String code, MedicineType type, MedicineForm form, String composition,
            String manufacturer, Boolean onPrescription, String replacement, String note, String contraindications,
            String dailyDose) {
        Id = id;
        Name = name;
        Code = code;
        Type = type;
        Form = form;
        Composition = composition;
        Manufacturer = manufacturer;
        OnPrescription = onPrescription;
        Replacement = replacement;
        Note = note;
        Contraindications = contraindications;
        DailyDose = dailyDose;
    }
	
	public Integer getGrade() {
		return Grade;
	}

	public void setGrade(Integer grade) {
		Grade = grade;
	}
}
