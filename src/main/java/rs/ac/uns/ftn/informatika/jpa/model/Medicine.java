package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.enums.MedicineType;

@Entity
@Table(name="Medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Code", unique=false, nullable=true)
	private String Code;
	
	@Column(name="Name", unique=false, nullable=true)
	private String Name;
	
	@Column(name="Type", unique=false, nullable=true)
	private MedicineType Type;
	
	@Column(name="Form", unique=false, nullable=true)
	private MedicineForm Form;
	
	@Column(name="Composition", unique=false, nullable=true)
	private String Composition;
	
	@Column(name="Manufacturer", unique=false, nullable=true)
	private String Manufacturer;
	
	@Column(name="OnPrescription", unique=false, nullable=true)
	private Boolean OnPrescription;
	
	@Column(name="Replacement", unique=false, nullable=true)
	@ElementCollection
	private Set<String> Replacement = new HashSet<String>();
	
	@Column(name="Note", unique=false, nullable=true)
	private String Note;

	@Column(name="Contraindications", unique=false, nullable=true)
	private String Contraindications;

	
	@Column(name="DailyDose", unique=false, nullable=true)
	private String DailyDose;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Markk> Marks = new HashSet<Markk>();

	//@OneToOne(mappedBy = "Medicine")
    //private MedicinePriceAndQuantity MedicinePriceAndQuantity;
	
	public Medicine(){}
/*
	public Medicine(long code, String name, MedicineType type, MedicineForm form, String composition, String manufacturer,
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
*/
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

	public MedicineType getType() {
		return Type;
	}

	public void setType(MedicineType type) {
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
	
	
	public void setContraindications(String contraindications) {
		Contraindications = contraindications;
	}

	public String getDailyDose() {
		return DailyDose;
	}

	public void setDailyDose(String dailyDose) {
		DailyDose = dailyDose;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}
	public Medicine(Long id, String name, String code, MedicineType type, MedicineForm form, String composition,
			String manufacturer, Boolean onPrescription, Set<String> replacement, String note, String contraindications,
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
	public Medicine(MedicineDTO medicineDTO) {
		Id = medicineDTO.getId();
		Name = medicineDTO.getName();
		Code = medicineDTO.getCode();
		Type = medicineDTO.getType();
		Form = medicineDTO.getForm();
		Composition = medicineDTO.getComposition();
		Manufacturer = medicineDTO.getManufacturer();
		OnPrescription = medicineDTO.getOnPrescription();
		String replacementParts[]=medicineDTO.getReplacement().split(",");
		HashSet<String> setReplacements=new HashSet<String>();
		for(String  i : replacementParts){
			setReplacements.add(i);
		}
		Replacement = setReplacements;
		Note = medicineDTO.getNote();
		Contraindications = medicineDTO.getContraindications();
		DailyDose = medicineDTO.getDailyDose();
	}
	
	public Set<Markk> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Markk> marks) {
		Marks = marks;
	}
}
