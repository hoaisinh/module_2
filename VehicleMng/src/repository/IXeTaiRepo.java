package repository;

import model.XeTai;

import java.util.List;

public interface IXeTaiRepo extends IVehicleRepo{
    public final static String PATH_XETAI = "src/data/xeTai.csv";
    List<XeTai> getAll();
    boolean addXeTai(XeTai xeTai);

    XeTai findByBKS(String bienKiemSoat);
}
