package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;

public class Patient extends User {
	private ArrayList<String> DrugAllargies;
	private int Points;
	private int Penalty;
	private LoyaltyCategories Category;
	
	public Patient(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber,String description, ArrayList<String> drugAllargies, int points, int penalty,
			LoyaltyCategories category) {
		super(id, email, password, name, surname, address, city, country, phoneNumber,description);
		DrugAllargies = drugAllargies;
		Points = points;
		Penalty = penalty;
		Category = category;
	}

	public ArrayList<String> getDrugAllargies() {
		return DrugAllargies;
	}

	public void setDrugAllargies(ArrayList<String> drugAllargies) {
		DrugAllargies = drugAllargies;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}

	public int getPenalty() {
		return Penalty;
	}

	public void setPenalty(int penalty) {
		Penalty = penalty;
	}

	public LoyaltyCategories getCategory() {
		return Category;
	}

	public void setCategory(LoyaltyCategories category) {
		Category = category;
	}
	
	
	
}
