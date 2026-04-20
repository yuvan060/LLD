package ATMMachine.state;

import ATMMachine.Entity.ATMContext;
import ATMMachine.Entity.Card;
import ATMMachine.Entity.Transaction;

public class IdleState implements ATMState {

    @Override
    public boolean insertCard(ATMContext atmContext, Card card) {
        atmContext.currentCard = card;
        // Transition to CardInsertedState
        atmContext.atmState = new CardInsertedState();
        return true;
    }

    @Override
    public boolean validateCard(ATMContext atmContext, int pin) {
        return false; // Cannot validate without card
    }

    @Override
    public Transaction selectTransaction(ATMContext atmContext) {
        return null; // Cannot select without validation
    }

    @Override
    public boolean processTransaction(ATMContext atmContext) {
        return false; // No transaction to process
    }

    @Override
    public boolean ejectCard(ATMContext atmContext) {
        return false; // No card to eject
    }
}
