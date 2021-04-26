package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import rs.ac.uns.ftn.informatika.jpa.model.MedicineQuantity;

public class OrderDTO {

	private Long Id;
	private Set<MedicineQuantityDTO> Orders = new HashSet<MedicineQuantityDTO>();
	private Date DueDate;
	private PharmacyAdmin PharmacyAdmin;
	
    public OrderDTO(){}

	public OrderDTO(long id, Set<MedicineQuantityDTO> orders, Date dueDate,PharmacyAdmin pharmacyAdmin) {
		this.Id = id;
		this.Orders = orders;
		DueDate = dueDate;
		PharmacyAdmin = pharmacyAdmin;
	}

    public OrderDTO(Order order) {
		this.Id = order.getId();
		Set<MedicineQuantity> m= order.getOrders();
		Set<MedicineQuantityDTO> result=new HashSet<>();
		for (MedicineQuantity medicineQuantityDTO : m) {
				result.add(new MedicineQuantityDTO(medicineQuantityDTO));
		}
		this.Orders =result;
		DueDate = order.getDueDate();
		PharmacyAdmin =order.getPharmacyAdmin();
	}

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	public Set<MedicineQuantityDTO> getOrders() {
		return Orders;
	}
	public void setOrders(Set<MedicineQuantityDTO> orders) {
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