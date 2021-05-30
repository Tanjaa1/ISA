package rs.ac.uns.ftn.informatika.jpa.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;

@Entity
@Table(name="MapLocation")
public class MapLocation {

    @javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
    
    @Column(name="x", unique=false, nullable=true)
    double Xaxis;

    @Column(name="y", unique=false, nullable=true)
    double Yaxis;

    @Column(name="PharmacyId", unique=false, nullable=false)
    Long Pharmacy;

    public MapLocation() {};

    public MapLocation(int X , int Y , Long pa) {
        Xaxis = X;
        Yaxis = Y;
        Pharmacy= pa;
    };

    public double getXaxis() {
        return Xaxis;
    }
    public void setXaxis(double xaxis) {
        Xaxis = xaxis;
    }

    public double getYaxis() {
        return Yaxis;
    }

    public void setYaxis(double yaxis) {
        Yaxis = yaxis;
    }

    public void incrementX(){
        Xaxis++;
    }
    public void incrementY(){
        Yaxis++;
    }
    public void addToY(double x){
        Yaxis = Yaxis + x;
    }
    public Long getPharmacy() {
        return Pharmacy;
    }
    public void setPharmacy(Long pharmacyAdminId) {
        Pharmacy = pharmacyAdminId;
    }
}
