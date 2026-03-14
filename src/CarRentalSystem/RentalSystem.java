package CarRentalSystem;

import CarRentalSystem.RentalStore.RentalStore;
import CarRentalSystem.Reservation.ReservationManager;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    public final List<RentalStore> rentalStores;
    public final ReservationManager reservationManager;

    public RentalSystem() {
        this.rentalStores = new ArrayList<>();
        reservationManager = ReservationManager.getInstance();
    }


}
