package VendingMachine.strategy;

public interface PaymentStrategy {
    public boolean processPayment(double amount);
}
