package rs.ac.uns.ftn.informatika.jpa.model;

public class ActionOrPromotion {
	private long Id;
	private String Text;
	private Pharmacy Pharmacy;
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
	public Pharmacy getPharmacy() {
		return Pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		Pharmacy = pharmacy;
	}
	public ActionOrPromotion(long id, String text, rs.ac.uns.ftn.informatika.jpa.model.Pharmacy pharmacy) {
		super();
		Id = id;
		Text = text;
		Pharmacy = pharmacy;
	}
}
