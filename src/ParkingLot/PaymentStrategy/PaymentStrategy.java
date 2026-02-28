package ParkingLot.PaymentStrategy;

public interface PaymentStrategy {
    public boolean makePayment(long durationInMinutes);
}
