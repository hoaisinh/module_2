package repository;

import model.XeTai;

import java.util.List;

public interface IXeTaiRepo {
    List<XeTai> getAll();
    boolean addXeTai(XeTai xeTai);
    void deleteXeTai(String bienKiemSoat);
}
