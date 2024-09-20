package service.car;

import model.vehicle.Car;
import repository.car.CarRepo;

import java.util.List;

public class CarService implements ICarService {
    private final CarRepo xeOtoRepo = new CarRepo();
    @Override
    public List<Car> getAll() {
        return xeOtoRepo.getAll();
    }

    @Override
    public void addVehicle(Car xeOto) {
        xeOtoRepo.addVehicle(xeOto);
    }

    @Override
    public Car findByBKS(String licensePlate) {
        return xeOtoRepo.findByBKS(licensePlate);
    }

    @Override
    public void updateVehicle(Car xeOto) {
        xeOtoRepo.updateVehicle(xeOto);
    }

    @Override
    public void deleteVehicle(String licensePlate) {
        xeOtoRepo.deleteVehicle(licensePlate);
    }
}
