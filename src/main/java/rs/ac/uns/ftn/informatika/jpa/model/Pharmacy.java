package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

public class Pharmacy {
	private long Id;
	private String Name;
	private String Address;
	private ArrayList<Integer> Marks;
	private ArrayList<MedicinePriceAndQuantity> Pricelist;
	private ArrayList<Patient>SubscribedUsers;
	
	public Pharmacy(long id,String name, String address, ArrayList<Integer> marks,ArrayList<MedicinePriceAndQuantity> pricelist,ArrayList<Patient> subscribedUsers) {
		super();
		Id=id;
		Name = name;
		Address = address;
		Marks = marks;
		Pricelist=pricelist;
		SubscribedUsers=subscribedUsers;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public ArrayList<Integer> getMarks() {
		return Marks;
	}

	public void setMarks(ArrayList<Integer> marks) {
		Marks = marks;
	}
}
