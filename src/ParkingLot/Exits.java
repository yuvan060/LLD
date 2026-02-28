package ParkingLot;

import ParkingLot.PaymentStrategy.PaymentStrategy;
import ParkingLot.Ticket.Ticket;

import java.sql.Time;

public class Exits {

    public final int position;

    public Exits(int position) {
        this.position = position;
    }

    public boolean exitVehicle(Ticket ticket) {
        if(!ticket.closeTicket(new Time(System.currentTimeMillis()), (duration) -> true)) {
            //handle retry
            return false;
        }
        return true;
    }
}
