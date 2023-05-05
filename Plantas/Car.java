package Java;



class Car {
    protected Integer id;
    protected String license;
    protected Account driver;
    protected Integer passengers;

    public Car(String license,Account driver){
        this.license=license;
        this.driver=driver;

    }

    public Integer getPassenger(){
        return this.passengers;
    }

    void pritDataCar(){
        System.out.println("License: "+ this.license +
        "  Driver: "+ this.driver.name + " Passengers: "+
            passengers);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Account getDriver() {
        return driver;
    }

    public void setDriver(Account driver) {
        this.driver = driver;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        if(passengers==4){
            this.passengers = passengers;
        }else{
            System.out.println("Debe ser minimo de 4");
        }

    }

    
}


