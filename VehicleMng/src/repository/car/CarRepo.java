package repository.car;

import common.File;
import model.vehicle.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRepo implements ICarRepo {
    @Override
    public List<Car> getAll() {
        List<String> lists = File.readFile(PATH_CAR);
        List<Car> carList = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            carList.add(new Car(arrData[0],arrData[1],arrData[3],Integer.parseInt(arrData[2]),Integer.parseInt(arrData[4]),arrData[5]));
        }
        return carList;
    }

    @Override
    public void addVehicle(Car car) {
        File.writeToFile(PATH_CAR,car.dataToString());
    }



    @Override
    public Car findByBKS(String licensePlate) {
        List<Car> cars = getAll();
        for (Car car:cars){
            if(Objects.equals(car.getLicensePlate(), licensePlate)){
                return car;
            }
        }
        return  null;
    }

    @Override
    public void updateVehicle(Car xeOto) {
        List<Car> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getLicensePlate(), xeOto.getLicensePlate())){
                lists.set(i,xeOto);
                break;
            }
        }
        File.clearData(PATH_CAR);
        for(Car xeOto1:lists){
            File.writeToFile(PATH_CAR,xeOto1.dataToString());
        }
    }

    @Override
    public void deleteVehicle(String licensePlate) {
        List<Car> lists = getAll();
        for (int i = 0; i < lists.size(); i++) {
            if(Objects.equals(lists.get(i).getLicensePlate(), licensePlate)){
                lists.remove(i);
                break;
            }
        }
        File.clearData(PATH_CAR);
        for(Car xeOto:lists){
            File.writeToFile(PATH_CAR,xeOto.dataToString());
        }
    }
}
