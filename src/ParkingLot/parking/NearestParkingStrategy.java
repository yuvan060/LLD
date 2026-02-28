package ParkingLot.parking;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.floor.Floor;
import ParkingLot.slot.Slot;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy{
    @Override
    public Slot park(List<Floor> floors, Vehicle vehicle) {
        for(Floor floor : floors) {
            for(Slot slot : floor.parkingSlots.get(vehicle.vehicleType).values()) {
                if(slot.tryOccupySlot()) {
                    return slot;
                }
            }
        }
        return null;
    }
}
