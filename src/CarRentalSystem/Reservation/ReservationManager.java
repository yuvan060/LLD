package CarRentalSystem.Reservation;

import CarRentalSystem.RentalStore.RentalStore;
import CarRentalSystem.Strategy.PaymentProcessor;
import CarRentalSystem.Strategy.PricingStrategy;
import CarRentalSystem.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.*;

public class ReservationManager {
    public final Map<Integer, Reservation> reservations;
    public PricingStrategy pricingStrategy;

    private ReservationManager() {
        this.reservations = new HashMap<>();
    }

    public Optional<Reservation> bookReservation(Vehicle vehicle, LocalDate startDate, LocalDate endDate, RentalStore pickUpStore, RentalStore returnStore) {
        if(!vehicle.bookVehicle()) {
            return Optional.empty();
        }
        Reservation reservation = new Reservation(new Random().nextInt(),pickUpStore, returnStore, vehicle, startDate, endDate, pricingStrategy);
        reservations.put(reservation.id, reservation);
        return Optional.of(reservation);
    }

    public boolean cancelReservation(int id) {
        return reservations.get(id).cancelReservation();
    }

    public boolean closeReservation(int id, PaymentProcessor paymentProcessor) {
        return reservations.get(id).returnVehicle(paymentProcessor);
    }

    public boolean isVehicleAvailable(Vehicle targetVehicle, LocalDate startDate, LocalDate endDate) {
        return reservations.values()
                .stream()
                .filter(reservation->reservation.vehicle.equals(targetVehicle))
                .noneMatch(r -> r.startDate.isBefore(endDate)
                        && r.endDate.isAfter(startDate));
    }

    private static class ReservationManagerInstanceHolder {
        private static final ReservationManager reservationManager = new ReservationManager();

        public static ReservationManager getReservationManager() {
            return reservationManager;
        }
    }

    public static  ReservationManager getInstance() {
        return ReservationManagerInstanceHolder.getReservationManager();
    }
}
