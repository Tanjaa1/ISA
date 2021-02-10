package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MedicineQuantity")
public class MedicineQuantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Medicine_id", referencedColumnName = "Id")
	private Medicine Medicine;
	
	@Column(name="Quantity", unique=false, nullable=true)
	private Integer Quantity;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// private Order OrderMedicine;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Supplier Supplier;
	
	public MedicineQuantity(){}

	public MedicineQuantity(long id, rs.ac.uns.ftn.informatika.jpa.model.Medicine medicine, int quantity) {
		super();
		this.Id = id;
		Medicine = medicine;
		Quantity = quantity;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public Medicine getMedicine() {
		return Medicine;
	}
	public void setMedicine(Medicine medicine) {
		Medicine = medicine;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
