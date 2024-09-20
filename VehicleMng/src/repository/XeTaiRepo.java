package repository;

import common.File;
import model.XeMay;
import model.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XeTaiRepo implements IXeTaiRepo{
    @Override
    public List<XeTai> getAll() {
        List<String> lists = File.readFile(PATH_XETAI);
        List<XeTai> xeTaiList = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            xeTaiList.add(new XeTai(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4])));
        }
        return xeTaiList;
    }

    @Override
    public Boolean addVehicle(XeTai xeTai) {
        File.writeToFile(PATH_XETAI,xeTai.dataToString());
        return true;
    }

    @Override
    public void deleteVehicle(String bienKiemSoat) {
        List<XeTai> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), bienKiemSoat)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_XETAI);
        for(XeTai xeTai:lists){
            File.writeToFile(PATH_XETAI,xeTai.dataToString());
        }
    }

    @Override
    public XeTai findByBKS(String bienKiemSoat) {
        List<XeTai> list = getAll();
        for (XeTai xeTai:list){
            if(Objects.equals(xeTai.getBienKiemSoat(), bienKiemSoat)){

                return xeTai;
            }
        }
        return  null;
    }

    @Override
    public void updateVehicle(XeTai xeTai) {
        List<XeTai> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getBienKiemSoat(), xeTai.getBienKiemSoat())){
                lists.set(i,xeTai);
                break;
            }
        }
        File.clearData(PATH_XETAI);
        for(XeTai xeTai1:lists){
            File.writeToFile(PATH_XETAI,xeTai1.dataToString());
        }
    }
}
