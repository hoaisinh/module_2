package repository;

import model.XeMay;

import java.util.List;

public interface IXeMayRepo extends IVehicleRepo{
    public final static String PATH_XEMAY = "src/data/xeMay.csv";
    List<XeMay> getAll();
    boolean addXeMay(XeMay xeMay);

    XeMay findByBKS(String bienKiemSoat);
}
