package service;

import model.XeOto;
import repository.XeOtoRepo;

import java.util.List;

public class XeOtoService implements IOtoService{
    private final XeOtoRepo xeOtoRepo = new XeOtoRepo();
    @Override
    public List<XeOto> getAll() {
        return xeOtoRepo.getAll();
    }

    @Override
    public boolean addVehicle(XeOto xeOto) {
        return xeOtoRepo.addVehicle(xeOto);
    }

    @Override
    public XeOto findByBKS(String bienKiemSoat) {
        return xeOtoRepo.findByBKS(bienKiemSoat);
    }

    @Override
    public void updateVehicle(XeOto xeOto) {
        xeOtoRepo.updateVehicle(xeOto);
    }

    @Override
    public void deleteVehicle(String bienKiemSoat) {
        xeOtoRepo.deleteVehicle(bienKiemSoat);
    }
}
