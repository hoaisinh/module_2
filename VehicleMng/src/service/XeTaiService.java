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
    public boolean addXeTai(XeTai xeTai) {
        return false;
    }

    @Override
    public void deleteXeTai(String bienKiemSoat) {

    }
}
