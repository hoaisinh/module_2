package service;

import model.XeMay;
import repository.XeMayRepo;

import java.util.List;

public class XeMayService implements IXeMayService{
    private final XeMayRepo xeMayRepo = new XeMayRepo();
    @Override
    public void deleteVehicle(String bienKiemSoat) {
        xeMayRepo.deleteVehicle(bienKiemSoat);
    }

    @Override
    public List<XeMay> getAll() {
        return xeMayRepo.getAll();
    }

    @Override
    public boolean addXeMay(XeMay xeMay) {
        return xeMayRepo.addXeMay(xeMay);
    }

    @Override
    public XeMay findByBKS(String bienKiemSoat) {
        return xeMayRepo.findByBKS(bienKiemSoat);
    }
}
