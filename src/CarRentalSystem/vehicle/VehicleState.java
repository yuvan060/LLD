package CarRentalSystem.vehicle;

import behavioural.state.Vechile;

public interface VehicleState {
    String getCurrentState();
    boolean bookVehicle(Vehicle vehicle);
    boolean cancelReservation(Vehicle vehicle);
    boolean returnVehicle(Vehicle vehicle);
}
