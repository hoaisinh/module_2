package service;

import model.XeTai;
import repository.XeTaiRepo;

import java.util.List;

public class XeTaiService implements IXeTaiService{
    private final XeTaiRepo xeTaiRepo = new XeTaiRepo();
    @Override
    public List<XeTai> getAll() {
        return xeTaiRepo.getAll();
    }

    @Override
    public boolean addVehicle(XeTai xeTai)
    {
        return xeTaiRepo.addVehicle(xeTai);
    }

    @Override
    public void deleteVehicle(String bienKiemSoat) {
        xeTaiRepo.deleteVehicle(bienKiemSoat);
    }

    @Override
    public XeTai findByBKS(String bienKiemSoat) {
        return xeTaiRepo.findByBKS(bienKiemSoat);
    }

    @Override
    public void updateVehicle(XeTai xeTai) {
        xeTaiRepo.updateVehicle(xeTai);
    }


}
