package repository.car;

import model.vehicle.Car;
import repository.IVehicleRepo;

public interface ICarRepo extends IVehicleRepo<Car> {
    String PATH_CAR = "src/data/car.csv";
}
