package CarRentalSystem.vehicle;

public abstract class Vehicle {
    public final int id;
    public final String model;
    public final String registrationNumber;
    public final VehicleCategory vehicleCategory;
    public final VehicleState vehicleState;

    public Vehicle(int id, String model, String registrationNumber, VehicleCategory vehicleCategory, VehicleState vehicleState) {
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vehicleCategory = vehicleCategory;
        this.vehicleState = vehicleState;
    }

    public synchronized boolean bookVehicle() {
        return vehicleState.bookVehicle(this);
    }

    public boolean cancelVehicle() {
        return vehicleState.cancelReservation(this);
    }

    public boolean returnVehicle() {
        return vehicleState.returnVehicle(this);
    }

    public abstract double getBaseRentalPrice();
}
