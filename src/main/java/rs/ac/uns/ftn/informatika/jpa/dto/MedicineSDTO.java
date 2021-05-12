package rs.ac.uns.ftn.informatika.jpa.dto;

import org.springframework.data.geo.Point;

import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.enums.MedicineType;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public class MedicineSDTO {
    private Long Id;
	private String Code;
	private String Name;
	private MedicineForm Form;
	private MedicineType Type;
	private String Composition;
	private String Manufacturer;
	private Boolean OnPrescription;
	private String Replacement;
	private String Note;
	private String Contraindications;
	private String DailyDose;
	private Integer Grade;
	private Integer Points;
	private String ReplacmentString;
    public MedicineSDTO(Long id, String code, String name, MedicineForm form, MedicineType type, String composition,
            String manufacturer, Boolean onPrescription, String replacement, String note, String contraindications,
            String dailyDose, Integer grade, String replacmentString) {
        Id = id;
        Code = code;
        Name = name;
        Form = form;
        Type = type;
        Composition = composition;
        Manufacturer = manufacturer;
        OnPrescription = onPrescription;
        Replacement = replacement;
        Note = note;
        Contraindications = contraindications;
        DailyDose = dailyDose;
        Grade = grade;
        ReplacmentString = replacmentString;
    }
    public MedicineSDTO(Long id, String code, String name, MedicineForm form, MedicineType type, String composition,
    String manufacturer, Boolean onPrescription, String replacement, String note, String contraindications,
    String dailyDose, Integer grade, String replacmentString,Integer points) {
        Id = id;
        Code = code;
        Name = name;
        Form = form;
        Type = type;
        Composition = composition;
        Manufacturer = manufacturer;
        OnPrescription = onPrescription;
        Replacement = replacement;
        Note = note;
        Contraindications = contraindications;
        DailyDose = dailyDose;
        Grade = grade;
        ReplacmentString = replacmentString;
        Points=points;
    }
    public MedicineSDTO(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public MedicineForm getForm() {
        return Form;
    }

    public void setForm(MedicineForm form) {
        Form = form;
    }

    public MedicineType getType() {
        return Type;
    }

    public void setType(MedicineType type) {
        Type = type;
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

    public String getReplacement() {
        return Replacement;
    }

    public void setReplacement(String replacement) {
        Replacement = replacement;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
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

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
    }

    public String getReplacmentString() {
        return ReplacmentString;
    }

    public void setReplacmentString(String replacmentString) {
        ReplacmentString = replacmentString;
    }
    public Integer getPoints() {
        return Points;
    }
    public void setPoints(Integer points) {
        Points = points;
    }

    

   
}
