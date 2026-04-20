package ATMMachine.Entity;

import ATMMachine.state.ATMState;
import ATMMachine.state.IdleState;

public class ATMContext {
    public Card currentCard;
    public Transaction transaction;
    public ATMState atmState;

    private ATMContext() {
        this.atmState = new IdleState(); // Initialize with idle state
    }

    private static class ATMContextInstanceHolder {
        private static final ATMContext atmContext = new ATMContext();

        public static ATMContext getAtmContext() {
            return atmContext;
        }
    }

    public static ATMContext getInstance() {
        return ATMContextInstanceHolder.getAtmContext();
    }
}
