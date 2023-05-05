package Java;

import java.util.ArrayList;
import java.util.Map;

public class UberSuv extends Car{
    Map<String, Map<String,Integer>> typeCarAccepted;
    ArrayList<String> seatsMaterial;

    UberSuv(String licence,Account driver,
    Map <String, Map<String,Integer>> typeCarAccepted,
    ArrayList <String> seatsMAterial){

        super(licence, driver);
        this.typeCarAccepted=typeCarAccepted;
        this.seatsMaterial=seatsMAterial;
    }
    
    UberSuv(String license,Account driver){
        super(license, driver);
        
    }

    
    @Override
    public void setPassengers(Integer passengers) {
        if(passengers>=6){
            this.passengers = passengers;
        }else{
            System.out.println("Debe ser minimo de 4");
        }

    }
}
