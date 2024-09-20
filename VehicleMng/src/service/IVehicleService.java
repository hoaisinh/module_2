package service;

import java.util.List;

public interface IVehicleService<T> {
    void deleteVehicle(String bienKiemSoat);
    List<T> getAll();
    boolean addVehicle(T t);
    T findByBKS(String bienKiemSoat);
    void updateVehicle(T t);
}
