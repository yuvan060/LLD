package ParkingLot;

import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.parking.ParkingLot;
import ParkingLot.slot.Slot;

import java.sql.Time;

public class Entries {

    public final int position;
    public final ParkingLot parkingLot;

    public Entries(int position) {
        this.position = position;
        this.parkingLot = ParkingLot.getInstance();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Slot slot = parkingLot.parkVehicle(vehicle);
        if(slot == null) {
            throw new RuntimeException("No Slot available...");
        }
        return new Ticket(vehicle, new Time(System.currentTimeMillis()), slot);
    }
}
