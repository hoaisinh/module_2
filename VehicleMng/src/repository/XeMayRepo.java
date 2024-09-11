package repository;

import common.File;
import model.XeMay;
import model.XeOto;
import model.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XeMayRepo implements IXeMayRepo{
    @Override
    public void deleteVehicle(String bienKiemSoat) {
        List<XeMay> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_XEMAY);
        for(XeMay xeMay:lists){
            File.writeToFile(PATH_XEMAY,xeMay.dataToString());
        }
    }

    @Override
    public List<XeMay> getAll() {
        List<String> lists = File.readFile(PATH_XEMAY);
        List<XeMay> xeMayList = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            xeMayList.add(new XeMay(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4])));
        }
        return xeMayList;
    }

    @Override
    public boolean addXeMay(XeMay xeMay) {
        File.writeToFile(PATH_XEMAY,xeMay.dataToString());
        return true;
    }
    @Override
    public XeMay findByBKS(String bienKiemSoat) {
        List<XeMay> list = getAll();
        for (XeMay xeMay:list){
            if(Objects.equals(xeMay.getBienKiemSoat(), bienKiemSoat)){
                return xeMay;
            }
        }
        return  null;
    }
}
