package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.enums.OfferStatus;

@Entity
@Table(name="SupplierOffer")
public class SupplierOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "OrderMedicine_id", referencedColumnName = "id")
	private Order Order;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Supplier_id", referencedColumnName = "id")
	private Supplier Supplier;
	
	@Column(name="Status", unique=false, nullable=true)
	private OfferStatus status;
	
	@Column(name="OfferPrice", unique=false, nullable=true)
	private Double OfferPrice;
	
	@Column(name="DueDate", unique=false, nullable=true)
	private String DueDate;
	
	public SupplierOffer(){}
	

	public void setId(Long id) {
		this.id = id;
	}


	public void setStatus(OfferStatus status) {
		this.status = status;
	}


	public void setOfferPrice(Double offerPrice) {
		OfferPrice = offerPrice;
	}


	public String getDueDate() {
		return DueDate;
	}


	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}


	public SupplierOffer(Long id,Order order,Supplier supplier, OfferStatus status, Double offerPrice,
	String dueDate) {
		this.id = id;
		Order = order;
		Supplier = supplier;
		this.status = status;
		OfferPrice = offerPrice;
		DueDate = dueDate;
	}


	public SupplierOffer(long id, Order order, Supplier supplier,
			OfferStatus status, Double offerPrice) {
		super();
		this.id = id;
		this.Order = order;
		Supplier = supplier;
		this.status = status;
		OfferPrice = offerPrice;
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		this.Order = order;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public OfferStatus getStatus() {
		return status;
	}
	public void setIsAccepted(OfferStatus status) {
		this.status = status;
	}
	public Double getOfferPrice() {
		return OfferPrice;
	}

}
