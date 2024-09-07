package repository;

import common.File;
import model.XeOto;
import model.XeTai;

import java.util.List;
import java.util.Objects;

public class XeOtoRepo implements IOtoRepo{
    @Override
    public List<XeOto> getAll() {
        return File.getAllXeOto();
    }

    @Override
    public boolean addXeOto(XeOto xeOto) {
        File.addXeOto(xeOto);
        return true;
    }

    @Override
    public XeOto findByBKS(String bienKiemSoat) {
        List<XeOto> list = File.getAllXeOto();
        for (XeOto xeOto:list){
            if(Objects.equals(xeOto.getBienKiemSoat(), bienKiemSoat)){
                return xeOto;
            }
        }
        return  null;
    }

    @Override
    public void deleteVehicle(String bienKiemSoat) {
        List<XeOto> lists = File.getAllXeOto();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.updateListXeOto(lists);
    }


}
