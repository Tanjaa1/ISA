package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineRequest;

public class MedicineRequestDTO {


	private Long Id;	
	private MedicineDTO Medicine;
	private LocalDateTime Date;
	private PharmacyDTO Pharmacy;
    private Boolean Solved;

	public MedicineRequestDTO(){
		Date=LocalDateTime.now();
		Solved=false;
	}

	public MedicineRequestDTO(long id,MedicineDTO medicine, LocalDateTime date, PharmacyDTO pharmacy,Boolean solved) {
		super();
		this.Id = id;
		Medicine = medicine;
		Date = date;
        Solved = solved;
	}

    public MedicineRequestDTO(MedicineRequest m) {
		super();
		this.Id = m.getId();
		Medicine = new MedicineDTO(m.getMedicine());
		Pharmacy = new PharmacyDTO(m.getPharmacy());
        Date = m.getDate();
        Solved = m.getSolved();
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public MedicineDTO getMedicine() {
		return Medicine;
	}
	public void setMedicine(MedicineDTO medicine) {
		Medicine = medicine;
	}
	public PharmacyDTO getPharmacy() {
		return Pharmacy;
	}
	public void setPharmacy(PharmacyDTO pharmacy) {
		Pharmacy = pharmacy;
	}

    public LocalDateTime getDate(){
        return Date;
    }

    public void setDate(LocalDateTime localDateTime){
        Date = localDateTime;
    }

    public Boolean getSolved() {
		return Solved;
	}
	public void setSolved(Boolean solved) {
		Solved = solved;
	}
}
