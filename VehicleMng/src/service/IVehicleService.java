package service;

import java.util.List;

public interface IVehicleService<T> {
    void deleteVehicle(String licensePlate);
    List<T> getAll();
    void addVehicle(T t);
    T findByBKS(String licensePlate);
    void updateVehicle(T t);
}
