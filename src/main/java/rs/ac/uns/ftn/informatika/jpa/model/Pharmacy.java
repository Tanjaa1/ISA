package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;


@Entity
@Table(name="Pharmacy")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Name", unique=false, nullable=true)
	private String Name;
	
	@Column(name="Address", unique=false, nullable=true)
	private String Address;

	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<MedicinePriceAndQuantity> Pricelist = new HashSet<MedicinePriceAndQuantity>();

	 @Column(name="CounselingPrice", unique=false, nullable=true)
	private Double CounselingPrice;
	
	 @ManyToMany
	 @JoinTable(name = "PharmacySubscribedUsers", joinColumns = @JoinColumn(name = "Pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Patient_id", referencedColumnName = "id"))
	 private Set<Patient> SubscribedUsers = new HashSet<Patient>();
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Set<Markk> Marks = new HashSet<Markk>();

	public Pharmacy(){}

	public Pharmacy(long id,String name, String address, Set<Markk> marks,Set<MedicinePriceAndQuantity> pricelist, Double counselingPrice/*,Set<Patient> subscribedUsers*/) {

		super();
		Id=id;
		Name = name;
		Address = address;
		Marks = marks;
		Pricelist=pricelist;
		CounselingPrice = counselingPrice;
	}

	public Long getId() {
		return Id;
	}

	public void setId(long id) {
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

	public Set<Markk> getMarks() {
		return Marks;
	}

	public void setMarks(Set<Markk> marks) {
		Marks = marks;
	}

	 public Set<MedicinePriceAndQuantity> getPricelist() {
	 	return Pricelist;
	 }

	 public void setPricelist(Set<MedicinePriceAndQuantity> pricelist) {
	 	Pricelist = pricelist;
	 }

	public Double getCounselingPrice() {
		return CounselingPrice;
	}

	public void setCounselingPrice(Double counselingPrice) {
		CounselingPrice = counselingPrice;
	}
	
	public Set<Patient> getSubscribedUsers(){
		return SubscribedUsers;
	}

	public void setSubscribedUsers(Set<Patient> su){
		SubscribedUsers = su;
	}

	public void setId(Long id) {
		Id = id;
	}
	public Pharmacy(PharmacyDTO pharmacyDTO) {
		Id=pharmacyDTO.getId();
		Name =pharmacyDTO.getName();
		Address = pharmacyDTO.getAddress();
	}
}
