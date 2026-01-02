package behavioural.stratergy.Payment;

public class Cardpayment implements Payment{
    @Override
    public void collectPaymentDetails() {
        //collect card details
    }

    @Override
    public Bill processPayment() throws PaymentException{
        //card service handles the logic
        return new Bill();
    }
}
