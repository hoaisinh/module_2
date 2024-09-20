package repository.motorbike;

import model.vehicle.Motorbike;
import repository.IVehicleRepo;

public interface IMotorbikeRepo extends IVehicleRepo<Motorbike> {
    String PATH_MOTORBIKE = "src/data/motorbike.csv";

}
