package model;

public abstract class Vehicle {
    private String licensePlate, manufacture, owner;
    private int yearOfManufacture;

    public Vehicle(String licensePlate, String manufacture, String owner, int yearOfManufacture) {
        this.licensePlate = licensePlate;
        this.manufacture = manufacture;
        this.owner = owner;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Vehicle {" +
                "licensePlate = " + licensePlate + 
                ", manufacture = " + manufacture +
                ", owner = " + owner +
                ", yearOfManufacture = " + yearOfManufacture ;
    }

    public String dataToString(){
        return licensePlate +","+ manufacture +","+ yearOfManufacture +","+ owner;
    }
}
