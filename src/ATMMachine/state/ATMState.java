package ATMMachine.state;

import ATMMachine.Entity.ATMContext;
import ATMMachine.Entity.Card;
import ATMMachine.Entity.Transaction;

public interface ATMState {
    boolean insertCard(ATMContext atmContext, Card card);
    boolean validateCard(ATMContext atmContext, int pin);
    Transaction selectTransaction(ATMContext atmContext);
    boolean processTransaction(ATMContext atmContext);
    boolean ejectCard(ATMContext atmContext);
}
