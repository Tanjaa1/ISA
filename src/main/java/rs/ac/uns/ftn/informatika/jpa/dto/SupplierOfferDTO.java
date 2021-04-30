package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.enums.OfferStatus;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;

public class SupplierOfferDTO {
    private Long id;
	private OrderDTO Order;
	private SupplierDTO Supplier;
	private OfferStatus status;
	private Double OfferPrice;
	private String DueDate;
    public SupplierOfferDTO(Long id, OrderDTO order, SupplierDTO supplier, OfferStatus status, Double offerPrice,
            String dueDate) {
        this.id = id;
        Order = order;
        Supplier = supplier;
        this.status = status;
        OfferPrice = offerPrice;
        DueDate = dueDate;
    }
    public SupplierOfferDTO(SupplierOffer so) {
        this.id = so.getId();
        Order = new OrderDTO(so.getOrder());
        Supplier = new SupplierDTO(so.getSupplier());
        this.status = so.getStatus();
        OfferPrice = so.getOfferPrice();
        DueDate = so.getDueDate();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OrderDTO getOrder() {
        return Order;
    }
    public void setOrder(OrderDTO order) {
        Order = order;
    }
    public SupplierDTO getSupplier() {
        return Supplier;
    }
    public void setSupplier(SupplierDTO supplier) {
        Supplier = supplier;
    }
    public OfferStatus getStatus() {
        return status;
    }
    public void setStatus(OfferStatus status) {
        this.status = status;
    }
    public Double getOfferPrice() {
        return OfferPrice;
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
    

    
}
