package service;

import model.XeMay;

import java.util.List;

public interface IXeMayService extends IVehicleService{
    List<XeMay> getAll();
    boolean addXeMay(XeMay xeMay);
    XeMay findByBKS(String bienKiemSoat);
}
