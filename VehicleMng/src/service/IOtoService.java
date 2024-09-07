package service;

import model.XeOto;

import java.util.List;

public interface IOtoService extends IVehicleService{
    List<XeOto> getAll();
    boolean addXeOto(XeOto xeOto);
    XeOto findByBKS(String bienKiemSoat);
}
