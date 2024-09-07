package service;

import model.XeTai;

import java.util.List;

public interface IXeTaiService extends IVehicleService{
    List<XeTai> getAll();
    boolean addXeTai(XeTai xeTai);
    XeTai findByBKS(String bienKiemSoat);
}
