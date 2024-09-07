package repository;

import model.XeMay;

import java.util.List;

public interface IXeMayRepo extends IVehicleRepo{
    List<XeMay> getAll();
    boolean addXeMay(XeMay xeMay);

    XeMay findByBKS(String bienKiemSoat);
}
