package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

public class PharmacyDTO {
    
	private Long Id;
	private String Name;
	private String Address;
	private Set<Integer> Marks = new HashSet<Integer>();
	private Set<MedicinePriceAndQuantity> Pricelist = new HashSet<MedicinePriceAndQuantity>();
    private Set<Patient> SubscribedUsers = new HashSet<Patient>();
	private Set<Dermatologist> Dermatologists = new HashSet<Dermatologist>();
	private Set<Pharmacist> Pharmacists = new HashSet<Pharmacist>();
    private Set<PharmacyAdmin> PharmacyAdmins = new HashSet<PharmacyAdmin>();

    public PharmacyDTO(Long id, String name, String address, Set<Integer> marks,
            Set<MedicinePriceAndQuantity> pricelist, Set<Patient> subscribedUsers, Set<Dermatologist> dermatologists,
            Set<Pharmacist> pharmacists, Set<PharmacyAdmin> pharmacyAdmins) {
        Id = id;
        Name = name;
        Address = address;
        Marks = marks;
        Pricelist = pricelist;
        SubscribedUsers = subscribedUsers;
        Dermatologists = dermatologists;
        Pharmacists = pharmacists;
        PharmacyAdmins = pharmacyAdmins;
    }

    public PharmacyDTO(Pharmacy pharmacy){
        super();
        Id=pharmacy.getId();
        Name=pharmacy.getName();
        Address=pharmacy.getAddress();
        Marks=pharmacy.getMarks();
    }

    public PharmacyDTO() {}

    public PharmacyDTO toDto(Pharmacy pharmacy){
        return new PharmacyDTO(pharmacy);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
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

    public Set<Integer> getMarks() {
        return Marks;
    }

    public void setMarks(Set<Integer> marks) {
        Marks = marks;
    }

    public Set<MedicinePriceAndQuantity> getPricelist() {
        return Pricelist;
    }

    public void setPricelist(Set<MedicinePriceAndQuantity> pricelist) {
        Pricelist = pricelist;
    }

    public Set<Patient> getSubscribedUsers() {
        return SubscribedUsers;
    }

    public void setSubscribedUsers(Set<Patient> subscribedUsers) {
        SubscribedUsers = subscribedUsers;
    }

    public Set<Dermatologist> getDermatologists() {
        return Dermatologists;
    }

    public void setDermatologists(Set<Dermatologist> dermatologists) {
        Dermatologists = dermatologists;
    }

    public Set<Pharmacist> getPharmacists() {
        return Pharmacists;
    }

    public void setPharmacists(Set<Pharmacist> pharmacists) {
        Pharmacists = pharmacists;
    }

    public Set<PharmacyAdmin> getPharmacyAdmins() {
        return PharmacyAdmins;
    }

    public void setPharmacyAdmins(Set<PharmacyAdmin> pharmacyAdmins) {
        PharmacyAdmins = pharmacyAdmins;
    }
    

    
	
    
}
