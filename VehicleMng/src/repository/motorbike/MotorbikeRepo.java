package repository.motorbike;

import common.File;
import model.vehicle.Motorbike;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MotorbikeRepo implements IMotorbikeRepo {
    @Override
    public void deleteVehicle(String licensePlate) {
        List<Motorbike> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getLicensePlate(), licensePlate)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_MOTORBIKE);
        for(Motorbike motorbike:lists){
            File.writeToFile(PATH_MOTORBIKE,motorbike.dataToString());
        }
    }

    @Override
    public List<Motorbike> getAll() {
        List<String> lists = File.readFile(PATH_MOTORBIKE);
        List<Motorbike> motorbikes = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            motorbikes.add(new Motorbike(arrData[0],arrData[1],arrData[3],Integer.parseInt(arrData[2]),Integer.parseInt(arrData[4])));
        }
        return motorbikes;
    }

    @Override
    public void addVehicle(Motorbike motorbike) {
            File.writeToFile(PATH_MOTORBIKE,motorbike.dataToString());
    }

    @Override
    public Motorbike findByBKS(String licensePlate) {
        List<Motorbike> list = getAll();
        for (Motorbike motorbike:list){
            if(Objects.equals(motorbike.getLicensePlate(), licensePlate)){
                return motorbike;
            }
        }
        return  null;
    }

    @Override
    public void updateVehicle(Motorbike motorbike) {
        List<Motorbike> motorbikes = getAll();
        for (int i = 0; i < motorbikes.size(); i++) {
            if(Objects.equals(motorbikes.get(i).getLicensePlate(), motorbike.getLicensePlate())){
                motorbikes.set(i,motorbike);
                break;
            }
        }
        File.clearData(PATH_MOTORBIKE);
        for(Motorbike motorbike1:motorbikes){
            File.writeToFile(PATH_MOTORBIKE,motorbike1.dataToString());
        }
    }
}
