package service.motorbike;

import model.vehicle.Motorbike;
import repository.motorbike.MotorbikeRepo;

import java.util.List;

public class MotorbikeService implements IMotorbikeService {
    private final MotorbikeRepo motorbikeRepo = new MotorbikeRepo();
    @Override
    public void deleteVehicle(String licensePlate) {
        motorbikeRepo.deleteVehicle(licensePlate);
    }

    @Override
    public List<Motorbike> getAll() {
        return motorbikeRepo.getAll();
    }

    @Override
    public void addVehicle(Motorbike motorbike) {
        motorbikeRepo.addVehicle(motorbike);
    }

    @Override
    public Motorbike findByBKS(String licensePlate) {
        return motorbikeRepo.findByBKS(licensePlate);
    }

    @Override
    public void updateVehicle(Motorbike motorbike) {
        motorbikeRepo.updateVehicle(motorbike);
    }
}
