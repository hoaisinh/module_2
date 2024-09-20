package repository;

import model.XeTai;

import java.util.List;

public interface IVehicleRepo<T> {

    void deleteVehicle(String bienKiemSoat);
    List<T> getAll();
    Boolean addVehicle(T t);
    T findByBKS(String bienKiemSoat);
    void updateVehicle(T t);
}
