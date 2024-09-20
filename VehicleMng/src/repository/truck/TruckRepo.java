package repository.truck;

import common.File;
import model.vehicle.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TruckRepo implements ITruckRepo {
    @Override
    public List<Truck> getAll() {
        List<String> lists = File.readFile(PATH_TRUCK);
        List<Truck> xeTaiList = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            xeTaiList.add(new Truck(arrData[0],arrData[1],arrData[3],Integer.parseInt(arrData[2]),Integer.parseInt(arrData[4])));
        }
        return xeTaiList;
    }

    @Override
    public void addVehicle(Truck xeTai) {
        File.writeToFile(PATH_TRUCK,xeTai.dataToString());
    }

    @Override
    public void deleteVehicle(String licensePlate) {
        List<Truck> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getLicensePlate(), licensePlate)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_TRUCK);
        for(Truck xeTai:lists){
            File.writeToFile(PATH_TRUCK,xeTai.dataToString());
        }
    }

    @Override
    public Truck findByBKS(String licensePlate) {
        List<Truck> list = getAll();
        for (Truck xeTai:list){
            if(Objects.equals(xeTai.getLicensePlate(), licensePlate)){

                return xeTai;
            }
        }
        return  null;
    }

    @Override
    public void updateVehicle(Truck xeTai) {
        List<Truck> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getLicensePlate(), xeTai.getLicensePlate())){
                lists.set(i,xeTai);
                break;
            }
        }
        File.clearData(PATH_TRUCK);
        for(Truck xeTai1:lists){
            File.writeToFile(PATH_TRUCK,xeTai1.dataToString());
        }
    }
}
