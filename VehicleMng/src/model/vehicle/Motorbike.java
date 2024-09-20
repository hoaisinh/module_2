package model.vehicle;

import model.Vehicle;

public class Motorbike extends Vehicle {
    private int capacity;

    public Motorbike(String licensePlate, String manufacture, String owner, int yearOfManufacture, int capacity) {
        super(licensePlate, manufacture, owner, yearOfManufacture);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", capacity = " + capacity +
                '}';
    }

    @Override
    public String dataToString() {
        return super.dataToString()+", capacity = "+ capacity;
    }
}
