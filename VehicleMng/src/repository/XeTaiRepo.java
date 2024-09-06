package repository;

import common.File;
import model.XeTai;

import java.util.List;

public class XeTaiRepo implements IXeTaiRepo{
    @Override
    public List<XeTai> getAll() {
        return File.getAllXeTai();
    }

    @Override
    public boolean addXeTai(XeTai xeTai) {
        return false;
    }

    @Override
    public void deleteXeTai(String bienKiemSoat) {

    }
}
