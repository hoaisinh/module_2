package repository;

import common.File;
import model.XeTai;

import java.util.List;
import java.util.Objects;

public class XeTaiRepo implements IXeTaiRepo{
    @Override
    public List<XeTai> getAll() {
        return File.getAllXeTai();
    }

    @Override
    public boolean addXeTai(XeTai xeTai) {
        File.addXeTai(xeTai);
        return true;

    }

    @Override
    public void deleteVehicle(String bienKiemSoat) {
            List<XeTai> lists = File.getAllXeTai();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.updateListXeTai(lists);
    }

    @Override
    public XeTai findByBKS(String bienKiemSoat) {
        List<XeTai> list = File.getAllXeTai();
        for (XeTai xeTai:list){
            if(Objects.equals(xeTai.getBienKiemSoat(), bienKiemSoat)){

                return xeTai;
            }
        }
        return  null;
    }
}
