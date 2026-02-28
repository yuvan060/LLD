package ParkingLot.slot;

import ParkingLot.ENUM.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class Slot {

    public final int position;
    public final VehicleType vehicleType;
    public AtomicBoolean isOccupied;

    public Slot(int position, VehicleType vehicleType) {
        this.position = position;
        this.vehicleType = vehicleType;
        this.isOccupied = new AtomicBoolean(false);
    }

    public boolean isAvailable() {
        return isOccupied.get();
    }

    public boolean tryOccupySlot() {
        return isOccupied.compareAndSet(false, true);
    }

    public boolean emptySlot() {
        return isOccupied.compareAndSet(true, false);
    }
}
