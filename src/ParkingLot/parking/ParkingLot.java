package ParkingLot.parking;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.floor.Floor;
import ParkingLot.slot.Slot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    public List<Floor> floors;
    public ParkingStrategy parkingStrategy;

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.parkingStrategy = new NearestParkingStrategy();
    }

    public Slot parkVehicle(Vehicle vehicle) {
        return parkingStrategy.park(floors, vehicle);
    }

    private static class ParkingLotInstanceHolder {
        private static final ParkingLot parkingLotInstance = new ParkingLot();

        public static ParkingLot getParkingLotInstance() {
            return parkingLotInstance;
        }
    }

    public static ParkingLot getInstance() {
        return ParkingLotInstanceHolder.getParkingLotInstance();
    }
}
