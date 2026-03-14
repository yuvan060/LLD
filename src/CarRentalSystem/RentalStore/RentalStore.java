package CarRentalSystem.RentalStore;

import CarRentalSystem.vehicle.Vehicle;
import CarRentalSystem.vehicle.VehicleCategory;

import java.util.*;
import java.util.stream.Collectors;

public class RentalStore {
    public final int Id;
    public final String location;
    public final double geoIndex;
    public final Map<VehicleCategory, List<Vehicle>> vehicles;

    public RentalStore(String location, double geoIndex, int id) {
        this.location = location;
        this.geoIndex = geoIndex;
        Id = id;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.computeIfAbsent(vehicle.vehicleCategory, k->new ArrayList<>()).add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.get(vehicle.vehicleCategory).remove(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(Set<VehicleCategory> vehicleCategorys) {
        return vehicleCategorys.stream()
                .flatMap(vehicleCategory -> vehicles.get(vehicleCategory).stream())
                .filter(vehicle -> vehicle.vehicleState.getCurrentState().equals("Available"))
                .collect(Collectors.toList());
     }
}
