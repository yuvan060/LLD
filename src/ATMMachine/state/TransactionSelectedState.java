package ATMMachine.state;

import ATMMachine.Entity.ATMContext;
import ATMMachine.Entity.Card;
import ATMMachine.Entity.Transaction;

public class TransactionSelectedState implements ATMState {

    @Override
    public boolean insertCard(ATMContext atmContext, Card card) {
        return false;
    }

    @Override
    public boolean validateCard(ATMContext atmContext, int pin) {
        return false;
    }

    @Override
    public Transaction selectTransaction(ATMContext atmContext) {
        return atmContext.transaction; // Already selected
    }

    @Override
    public boolean processTransaction(ATMContext atmContext) {
        if (atmContext.transaction != null) {
            boolean success = atmContext.transaction.execute(atmContext);
            if (success) {
                atmContext.atmState = new IdleState(); // Or success state
            } else {
                atmContext.atmState = new IdleState(); // Or failed state
            }
            return success;
        }
        return false;
    }

    @Override
    public boolean ejectCard(ATMContext atmContext) {
        atmContext.currentCard = null;
        atmContext.atmState = new IdleState();
        return true;
    }
}
