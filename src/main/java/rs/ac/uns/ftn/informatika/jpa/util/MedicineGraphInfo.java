package rs.ac.uns.ftn.informatika.jpa.util;

public class MedicineGraphInfo {
    int Xaxis;
    int Yaxis;

    public MedicineGraphInfo() {};

    public MedicineGraphInfo(int X , int Y) {
        Xaxis = X;
        Yaxis = Y;
    };

    public int getXaxis() {
        return Xaxis;
    }
    public void setXaxis(int xaxis) {
        Xaxis = xaxis;
    }

    public int getYaxis() {
        return Yaxis;
    }

    public void setYaxis(int yaxis) {
        Yaxis = yaxis;
    }

    public void incrementX(){
        Xaxis++;
    }
    public void incrementY(){
        Yaxis++;
    }
    public void addToY(int x){
        Yaxis = Yaxis + x;
    }
}
