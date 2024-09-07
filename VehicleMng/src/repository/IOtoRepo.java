package repository;

import model.XeOto;

import java.util.List;

public interface IOtoRepo extends IVehicleRepo{
    List<XeOto> getAll();
    boolean addXeOto(XeOto xeOto);
    XeOto findByBKS(String bienKiemSoat);

}
