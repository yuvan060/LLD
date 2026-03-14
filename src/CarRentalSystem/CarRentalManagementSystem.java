package CarRentalSystem;

public class CarRentalManagementSystem {
    /*
    Design a Car Rental Management System :
        The system should have various number of vehicles

        Each vehicles type of vehicles should has its own way pricing,

        Rental store should contain different number of vehicles,
        the system has multiple Rental shops, a car rented out from a store can be returned to another store

        After reserving a vehicles, we should be able to cancel the reservation if needed.


     Entities : -

     Vehicle abstract class - id, name, model, registration number, vehicleCategory, vehicleState;
                                isAvailable(), book(), cancel(), return, getBaseRentalPrice()
     Vehicle can be extended by Luxury cars, Base Model cars, seden cars luxury has its own getBaseRentalPrice() impl

     RentalStore - id, location, geoIndex, Map<Category, List<Vehicle>>;
                    addVehicle(), removeVehicle(), bookVehicle(), getAvailableVehicles()

     Reservation - id, BookDate, pickUpStore, returnStore, Vehicle, ReservationStatus, ReservationAmount, PricingStrategy
                    cancelReservation(), returnVehicle(PaymentProcessor)

     ReservationManager - Map<Integer, Reservations>
                           bookVehicle(), cancel, return...

         RentalSystem - List<RentalStore>, ReservationManager,
                    getAvailableVehicles(), bookVehicle, cancelVehicle, returnVehicle


     ReservationState - interface - book(vehicles), cancel(vehicles), return(vehicles)
     each state has its own management
     PaymentProcessor abstract class has processPayment(double amount); implemented by paymentProcessors

     PricingStrategy to decouple the pricing strategy as we can modify the strategy based on weekends or weekdays...
     */
}
