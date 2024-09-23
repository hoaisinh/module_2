package model.vehicle;

import model.Vehicle;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String vehicleType;


    public Car(String licensePlate, String manufacture, String owner, int yearOfManufacture, int numberOfSeats, String vehicleType) {
        super(licensePlate, manufacture, owner, yearOfManufacture);
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return  "Car {"+super.toString() +
                ", numberOfSeats = " + numberOfSeats +
                ", vehicleType = " + vehicleType +
                "}";
    }

    @Override
    public String dataToString() {
        return super.dataToString()+","+ numberOfSeats +","+ vehicleType;
    }
}
