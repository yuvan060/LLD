package ParkingLot.parking;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.floor.Floor;
import ParkingLot.slot.Slot;

import java.util.List;

public interface ParkingStrategy {
    public Slot park(List<Floor> floors, Vehicle vehicle);
}
