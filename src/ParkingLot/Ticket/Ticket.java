package ParkingLot.Ticket;

import ParkingLot.PaymentStrategy.PaymentStrategy;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.parking.ParkingStrategy;
import ParkingLot.slot.Slot;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Ticket {

    public final UUID ticketNumber;
    public final Vehicle vehicle;
    public final Time entryTime;
    public final Slot slot;

    public Ticket(Vehicle vehicle, Time entryTime, Slot slot) {
        this.ticketNumber = UUID.randomUUID();
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.slot = slot;
    }

    public boolean closeTicket(Time exitTime, PaymentStrategy paymentStrategy) {
        long duration = exitTime.getTime() - entryTime.getTime();
        if(!paymentStrategy.makePayment(duration)) {
            return false;
        }
        return slot.emptySlot();
    }
}
