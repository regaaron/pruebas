package Java;

import java.util.ArrayList;
import java.util.Map;

public class UberBlack extends Car{
    Map<String, Map<String,Integer>> typeCarAccepted;
    ArrayList<String> seatsMaterial;
    UberBlack(String licence,Account driver,
    Map <String, Map<String,Integer>> typeCarAccepted,
    ArrayList <String> seatsMAterial){
        super(licence, driver);
        this.typeCarAccepted=typeCarAccepted;
        this.seatsMaterial=seatsMAterial;
    }
}
