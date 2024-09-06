package service;

import model.XeTai;

import java.util.List;

public interface IXeTaiService {
    List<XeTai> getAll();
    boolean addXeTai(XeTai xeTai);
    void deleteXeTai(String bienKiemSoat);
}
