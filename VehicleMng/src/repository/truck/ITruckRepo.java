package repository.truck;

import model.vehicle.Truck;
import repository.IVehicleRepo;

public interface ITruckRepo extends IVehicleRepo<Truck> {
     String PATH_TRUCK = "src/data/truck.csv";

}
