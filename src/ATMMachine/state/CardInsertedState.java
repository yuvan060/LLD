package ATMMachine.state;

import ATMMachine.Entity.ATMContext;
import ATMMachine.Entity.Card;
import ATMMachine.Entity.Transaction;

public class CardInsertedState implements ATMState {

    @Override
    public boolean insertCard(ATMContext atmContext, Card card) {
        return false; // Card already inserted
    }

    @Override
    public boolean validateCard(ATMContext atmContext, int pin) {
        if (atmContext.currentCard != null && atmContext.currentCard.validateCard(pin)) {
            atmContext.atmState = new PinValidatedState();
            return true;
        }
        return false;
    }

    @Override
    public Transaction selectTransaction(ATMContext atmContext) {
        return null; // Need validation first
    }

    @Override
    public boolean processTransaction(ATMContext atmContext) {
        return false;
    }

    @Override
    public boolean ejectCard(ATMContext atmContext) {
        atmContext.currentCard = null;
        atmContext.atmState = new IdleState();
        return true;
    }
}
