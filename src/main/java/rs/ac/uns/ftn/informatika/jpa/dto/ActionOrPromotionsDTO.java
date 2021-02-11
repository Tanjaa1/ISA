package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;

public class ActionOrPromotionsDTO {
    
	private Long Id;
	private String Text;
	private PharmacyDTO PharmacyDTO;
	private MedicineDTO Medicine;
	private LocalDateTime StartTime;
	private LocalDateTime EndTime;

	public ActionOrPromotionsDTO(){}

	public ActionOrPromotionsDTO(long id, String text, PharmacyDTO pharmacy, MedicineDTO medicine,LocalDateTime sd,LocalDateTime ed) {
		super();
		Id = id;
		Text = text;
		PharmacyDTO = pharmacy;
		Medicine = medicine;
		StartTime = sd;
		EndTime = ed;
	}

    public ActionOrPromotionsDTO(ActionOrPromotion ationOrPromotion){
        Id = ationOrPromotion.getId();
        Text = ationOrPromotion.getText();
        PharmacyDTO = new PharmacyDTO(ationOrPromotion.getPharmacy());
        Medicine = new MedicineDTO(ationOrPromotion.getMedicine());
		StartTime = ationOrPromotion.getStartTime();
		EndTime = ationOrPromotion.getEndTime();
    }
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	 public PharmacyDTO getPharmacy() {
	 	return PharmacyDTO;
	 }
	 public void setPharmacy(PharmacyDTO pharmacy) {
	 	PharmacyDTO = pharmacy;
	 }

	 public MedicineDTO getMedicine() {
		return Medicine;
	}
	public void setMedicine(MedicineDTO medicine) {
		Medicine = medicine;
	}

	public LocalDateTime getStartTime() {
		return StartTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		StartTime = startTime;
	}

	public LocalDateTime getEndDateTime() {
		return EndTime;
	}
	public void setEndTIme(LocalDateTime endTime) {
		EndTime = endTime;
	}
}
