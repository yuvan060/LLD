package CarRentalSystem.Reservation;

import CarRentalSystem.RentalStore.RentalStore;
import CarRentalSystem.Strategy.PaymentProcessor;
import CarRentalSystem.Strategy.PricingStrategy;
import CarRentalSystem.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.Date;

enum ReservationState {
    RESERVED,
    PICKED_UP,
    RETURNED,
    CANCELLED
}

public class Reservation {
    public final int id;
    public final RentalStore pickUpStore;
    public final RentalStore returnStore;
    public final Vehicle vehicle;
    public final LocalDate startDate;
    public final LocalDate endDate;
    public ReservationState reservationState;
    public final PricingStrategy pricingStrategy;

    public Reservation(int id, RentalStore pickUpStore, RentalStore returnStore, Vehicle vehicle, LocalDate startDate, LocalDate endDate, PricingStrategy pricingStrategy) {
        this.id = id;
        this.pickUpStore = pickUpStore;
        this.returnStore = returnStore;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricingStrategy = pricingStrategy;
        this.reservationState = ReservationState.RESERVED;
    }

    public boolean pickUpVehicle() {
        reservationState = ReservationState.PICKED_UP;
        pickUpStore.removeVehicle(vehicle);
        return true;
    }

    public boolean cancelReservation() {
        if(!vehicle.cancelVehicle()) {
            return false;
        }
        pickUpStore.addVehicle(vehicle);
        reservationState = ReservationState.CANCELLED;
        return true;
    }

    public boolean returnVehicle(PaymentProcessor paymentProcessor) {
        double amount = pricingStrategy.calculateRent(vehicle);
        if(!paymentProcessor.processPayment(amount) && vehicle.returnVehicle()) {
            return false;
        }
        reservationState = ReservationState.RETURNED;
        returnStore.addVehicle(vehicle);
        return true;
    }

}
