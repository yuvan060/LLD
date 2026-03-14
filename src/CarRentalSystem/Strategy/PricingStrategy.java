package CarRentalSystem.Strategy;

import CarRentalSystem.vehicle.Vehicle;

public interface PricingStrategy {
    double calculateRent(Vehicle vehicle);
}
