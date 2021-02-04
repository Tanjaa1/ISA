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
import javax.persistence.Table;

@Entity
@Table(name="OrderMedicine")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MedicineQuantity> Orders = new HashSet<MedicineQuantity>();
	
	@Column(name="DueDate", unique=false, nullable=true)
	private Date DueDate;
	
	@OneToOne(cascade = CascadeType.ALL)
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
	public long getId() {
		return Id;
	}
	public void setId(long id) {
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
