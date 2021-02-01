package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.enums.MedicineForm;

@Entity
@Table(name="Medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Code;
	
	@Column(name="Name", unique=false, nullable=true)
	private String Name;
	
	@Column(name="Type", unique=false, nullable=true)
	private String Type;
	
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
	
	//@OneToOne(mappedBy = "Medicine")
    //private MedicinePriceAndQuantity MedicinePriceAndQuantity;
	
	public Medicine(long code, String name, String type, MedicineForm form, String composition, String manufacturer,
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
