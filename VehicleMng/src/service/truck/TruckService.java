package service.truck;

import model.vehicle.Truck;
import repository.truck.TruckRepo;

import java.util.List;

public class TruckService implements ITruckService {
    private final TruckRepo truckRepo = new TruckRepo();
    @Override
    public List<Truck> getAll() {
        return truckRepo.getAll();
    }

    @Override
    public void addVehicle(Truck truck)
    {
        truckRepo.addVehicle(truck);
    }

    @Override
    public void deleteVehicle(String licensePlate) {
        truckRepo.deleteVehicle(licensePlate);
    }

    @Override
    public Truck findByBKS(String licensePlate) {
        return truckRepo.findByBKS(licensePlate);
    }

    @Override
    public void updateVehicle(Truck truck) {
        truckRepo.updateVehicle(truck);
    }


}
