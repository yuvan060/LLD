package behavioural.stratergy;

import behavioural.stratergy.Payment.Cardpayment;
import behavioural.stratergy.Payment.Payment;
import behavioural.stratergy.Payment.PaymentException;
import behavioural.stratergy.Payment.UpiPayment;

public class Order {
    public boolean processOrder(Cart cart, int retryCount) {
        //process the cart
        try {
            Payment paymentMethod = intiatePayment();
            paymentMethod.collectPaymentDetails();
            paymentMethod.processPayment();
        } catch (PaymentException e) {
            //retry logic for defined timed, if failed
            if(retryCount > 0) {
                return processOrder(cart, retryCount-1);
            }
            return false;
        }
        return true;
    }

    private Payment intiatePayment() {
        String userInput = "";
        //read from the client
        //based on the user inputs returns the Payment object
        if(userInput.equals("Card")) {
            return new Cardpayment();
        }else {
            return new UpiPayment();
        }
    }
}
