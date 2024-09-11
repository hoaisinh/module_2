package repository;

import model.XeOto;

import java.util.List;

public interface IOtoRepo extends IVehicleRepo{
    public final static String PATH_XEOTO = "src/data/oto.csv";
    List<XeOto> getAll();
    boolean addXeOto(XeOto xeOto);
    XeOto findByBKS(String bienKiemSoat);

}
