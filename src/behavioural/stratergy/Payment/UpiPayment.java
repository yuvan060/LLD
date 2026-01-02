package behavioural.stratergy.Payment;

public class UpiPayment implements Payment{
    @Override
    public void collectPaymentDetails() {
        //collect upi details
    }

    @Override
    public Bill processPayment() throws PaymentException{
        //logics are handled by Upi payments service
        return new Bill();
    }
}
