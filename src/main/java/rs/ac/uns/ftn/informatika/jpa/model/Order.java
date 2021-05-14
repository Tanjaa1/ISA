package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;

@Entity
@Table(name="OrderMedicine")
public class Order {
	
	@Id
	@SequenceGenerator(name = "Id", sequenceName = "Id1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id")
	private Long Id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<MedicineQuantity> Orders = new HashSet<MedicineQuantity>();
	
	@Column(name="DueDate", unique=false, nullable=true)
	private Date DueDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PharmacyAdmin_id", referencedColumnName = "id")
	private PharmacyAdmin PharmacyAdmin;
	
	public Order(){}

	public Order(long id, Set<MedicineQuantity> orders, Date dueDate,PharmacyAdmin pharmacyAdmin) {
		super();
		this.Id = id;
		this.Orders = orders;
		DueDate = dueDate;
		PharmacyAdmin = pharmacyAdmin;
	}
	public Order(OrderDTO o) {
		super();
		this.Id = o.getId();
		Set<MedicineQuantityDTO> m=o.getOrders();
		Set<MedicineQuantity>result=new HashSet<>();
		for (MedicineQuantityDTO medicineQuantity : m) {
			result.add(new MedicineQuantity(medicineQuantity));
		}
		this.Orders = result;
		DueDate = o.getDueDate();
		PharmacyAdmin = new PharmacyAdmin(o.getPharmacyAdmin());
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public Set<MedicineQuantity> getOrders() {
		return Orders;
	}
	public void setOrders(Set<MedicineQuantity> orders) {
		this.Orders = orders;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	public PharmacyAdmin getPharmacyAdmin() {
		return PharmacyAdmin;
	}
	public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
		PharmacyAdmin = pharmacyAdmin;
	}
}
