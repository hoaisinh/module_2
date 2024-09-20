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
    public boolean addVehicle(XeMay xeMay) {
        return xeMayRepo.addVehicle(xeMay);
    }

    @Override
    public XeMay findByBKS(String bienKiemSoat) {
        return xeMayRepo.findByBKS(bienKiemSoat);
    }

    @Override
    public void updateVehicle(XeMay xeMay) {
        xeMayRepo.updateVehicle(xeMay);
    }
}
