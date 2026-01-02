package behavioural.stratergy.Payment;

class Bill {

}

public interface Payment {
    void collectPaymentDetails();
    Bill processPayment() throws PaymentException;
}
