package ParkingLot.Vehicle;

import ParkingLot.ENUM.VehicleType;
import ParkingLot.slot.Slot;

public class Vehicle {
    public final String licensePlate;
    public final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
}
