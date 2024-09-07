package repository;

import model.XeTai;

import java.util.List;

public interface IXeTaiRepo extends IVehicleRepo{
    List<XeTai> getAll();
    boolean addXeTai(XeTai xeTai);

    XeTai findByBKS(String bienKiemSoat);
}
