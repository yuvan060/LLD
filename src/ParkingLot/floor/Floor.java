package ParkingLot.floor;

import ParkingLot.ENUM.VehicleType;
import ParkingLot.slot.Slot;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Floor {

    public final HashMap<VehicleType, ConcurrentHashMap<Integer, Slot>> parkingSlots;
    public final int floorNumber;

    public Floor(HashMap<VehicleType, ConcurrentHashMap<Integer, Slot>> parkingSlots, int floorNumber) {
        this.parkingSlots =parkingSlots;
        this.floorNumber = floorNumber;
    }

    public void addSlot(VehicleType vehicleType,Slot slot) {
        parkingSlots.get(vehicleType).put(slot.position, slot);
    }

}
