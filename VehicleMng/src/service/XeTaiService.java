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
    public boolean addXeTai(XeTai xeTai)
    {
        return xeTaiRepo.addXeTai(xeTai);
    }

    @Override
    public void deleteXeTai(String bienKiemSoat) {
        xeTaiRepo.deleteXeTai(bienKiemSoat);
    }

    @Override
    public XeTai findByBKS(String bienKiemSoat) {
        return xeTaiRepo.findByBKS(bienKiemSoat);
    }
}
