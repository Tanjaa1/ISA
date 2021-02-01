package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private long id;
	private ArrayList<MedicineQuantity> orders;
	private Date DueDate;
	private PharmacyAdmin PharmacyAdmin;
	public Order(long id, ArrayList<MedicineQuantity> orders, Date dueDate,
			rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin pharmacyAdmin) {
		super();
		this.id = id;
		this.orders = orders;
		DueDate = dueDate;
		PharmacyAdmin = pharmacyAdmin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ArrayList<MedicineQuantity> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<MedicineQuantity> orders) {
		this.orders = orders;
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
