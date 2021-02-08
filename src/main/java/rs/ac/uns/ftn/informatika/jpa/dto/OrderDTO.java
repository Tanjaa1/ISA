package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import rs.ac.uns.ftn.informatika.jpa.model.MedicineQuantity;

public class OrderDTO {

	private Long Id;
	private Set<MedicineQuantity> Orders = new HashSet<MedicineQuantity>();
	private Date DueDate;
	private PharmacyAdmin PharmacyAdmin;
	
    public OrderDTO(){}

	public OrderDTO(long id, Set<MedicineQuantity> orders, Date dueDate,PharmacyAdmin pharmacyAdmin) {
		this.Id = id;
		this.Orders = orders;
		DueDate = dueDate;
		PharmacyAdmin = pharmacyAdmin;
	}

    public OrderDTO(Order order) {
		this.Id = order.getId();
		this.Orders = order.getOrders();
		DueDate = order.getDueDate();
		PharmacyAdmin = order.getPharmacyAdmin();
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