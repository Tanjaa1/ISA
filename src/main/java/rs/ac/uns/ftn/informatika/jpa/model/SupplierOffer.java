package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

public class SupplierOffer {
	private long id;
	private Order order;
	private Supplier Supplier;
	private Boolean isAccepted;
	private double OfferPrice;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public Boolean getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public double getOfferPrice() {
		return OfferPrice;
	}
	public void setOfferPrice(double offerPrice) {
		OfferPrice = offerPrice;
	}
	public SupplierOffer(long id, Order order, rs.ac.uns.ftn.informatika.jpa.model.Supplier supplier,
			Boolean isAccepted, double offerPrice) {
		super();
		this.id = id;
		this.order = order;
		Supplier = supplier;
		this.isAccepted = isAccepted;
		OfferPrice = offerPrice;
	}	
}
