package model.vehicle;

import model.Vehicle;

public class Truck extends Vehicle {
    private int payload;

    public Truck(String licensePlate, String manufacture, String owner, int yearOfManufacture, int payload) {
        super(licensePlate, manufacture, owner, yearOfManufacture);
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString()+", payload = "+payload
                +"}";
    }

    @Override
    public String dataToString() {
        return super.dataToString()+", payload = "+ payload;
    }
}
