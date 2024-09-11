package repository;

import common.File;
import model.XeMay;
import model.XeOto;
import model.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XeOtoRepo implements IOtoRepo{
    @Override
    public List<XeOto> getAll() {
        List<String> lists = File.readFile(PATH_XEOTO);
        List<XeOto> xeOtoList = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            xeOtoList.add(new XeOto(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4]),arrData[5]));
        }
        return xeOtoList;
    }

    @Override
    public boolean addXeOto(XeOto xeOto) {
        File.writeToFile(PATH_XEOTO,xeOto.dataToString());
        return true;
    }

    @Override
    public XeOto findByBKS(String bienKiemSoat) {
        List<XeOto> list = getAll();
        for (XeOto xeOto:list){
            if(Objects.equals(xeOto.getBienKiemSoat(), bienKiemSoat)){
                return xeOto;
            }
        }
        return  null;
    }
    @Override
    public void deleteVehicle(String bienKiemSoat) {
        List<XeOto> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_XEOTO);
        for(XeOto xeOto:lists){
            File.writeToFile(PATH_XEOTO,xeOto.dataToString());
        }
    }
}
