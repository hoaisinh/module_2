package repository;

import common.File;
import model.XeMay;
import model.XeOto;
import model.XeTai;

import java.util.List;
import java.util.Objects;

public class XeMayRepo implements IXeMayRepo{
    @Override
    public void deleteVehicle(String bienKiemSoat) {
        List<XeMay> lists = File.getAllXeMay();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.updateListXeMay(lists);
    }

    @Override
    public List<XeMay> getAll() {
        return File.getAllXeMay();
    }

    @Override
    public boolean addXeMay(XeMay xeMay) {
        File.addXeMay(xeMay);
        return true;
    }

    @Override
    public XeMay findByBKS(String bienKiemSoat) {
        List<XeMay> list = File.getAllXeMay();
        for (XeMay xeMay:list){
            if(Objects.equals(xeMay.getBienKiemSoat(), bienKiemSoat)){
                return xeMay;
            }
        }
        return  null;
    }
}
