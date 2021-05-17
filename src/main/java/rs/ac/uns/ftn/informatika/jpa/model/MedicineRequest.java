package rs.ac.uns.ftn.informatika.jpa.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRequestDTO;

@Entity
@Table(name="MedicineRequest")
public class MedicineRequest {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Medicine_id", referencedColumnName = "Id")
	private Medicine Medicine;

    @Column(name="Date", unique=false, nullable=true)
	private LocalDateTime Date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Pharmacy_id", referencedColumnName = "Id")
	private Pharmacy Pharmacy;

    @Column(name="Solved", unique=false, nullable=true)
	private Boolean Solved;

	public MedicineRequest(){}

	public MedicineRequest(long id,Medicine medicine, LocalDateTime date, Pharmacy pharmacy,Boolean solved) {
		super();
		this.Id = id;
		Medicine = medicine;
		Date = date;
        Solved = solved;
	}

	public MedicineRequest(MedicineRequestDTO m) {
		super();
		this.Id = m.getId();
		Medicine = new Medicine(m.getMedicine());
		Pharmacy = new Pharmacy(m.getPharmacy());
        Date = m.getDate();
        Solved = m.getSolved();
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
	public Pharmacy getPharmacy() {
		return Pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}

    public Boolean getSolved() {
		return Solved;
	}
	public void setSolved(Boolean solved) {
		Solved = solved;
	}

    public LocalDateTime getDate(){
        return Date;
    }

    public void setDate(LocalDateTime localDateTime){
        Date = localDateTime;
    }
}
