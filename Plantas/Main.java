package Java;

class Main{
    public static void main(String[] args) {
        UberX uberx = new UberX("AMQ123",new Account("Luis Aaron", "AND123"),"Chevrolet","Sonic");
      
        uberx.setPassengers(8);
        uberx.pritDataCar();
       
        UberSuv ubersuv = new UberSuv("FGH12",new Account("Agustin Lopez","AND12"));
        ubersuv.setPassengers(6);
        ubersuv.pritDataCar();
        /*
         Car car2 = new Car("QWE567",new Account("Aaron Lopez","ANDA876"));
        car2.passengers=3;
        car2.pritDataCar();
         
         */
        
    }
}