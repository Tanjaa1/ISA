package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SupplierOffer")
public class SupplierOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderMedicine_id", referencedColumnName = "id")
	private Order Order;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Supplier_id", referencedColumnName = "id")
	private Supplier Supplier;
	
	@Column(name="IsAccepted", unique=false, nullable=true)
	private Boolean isAccepted;
	
	@Column(name="OfferPrice", unique=false, nullable=true)
	private Double OfferPrice;
	
	public SupplierOffer(long id, Order order, Supplier supplier,
			Boolean isAccepted, double offerPrice) {
		super();
		this.id = id;
		//this.Order = order;
		Supplier = supplier;
		this.isAccepted = isAccepted;
		OfferPrice = offerPrice;
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		this.Order = order;
	}*/
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
}
