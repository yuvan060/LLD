package ATMMachine.state;

import ATMMachine.Entity.ATMContext;
import ATMMachine.Entity.Card;
import ATMMachine.Entity.Transaction;
import ATMMachine.ENUM.TransactionStatus;
import ATMMachine.ENUM.TransactionType;
import ATMMachine.Entity.WithdrawTransaction;

import java.util.UUID;

public class PinValidatedState implements ATMState {

    @Override
    public boolean insertCard(ATMContext atmContext, Card card) {
        return false;
    }

    @Override
    public boolean validateCard(ATMContext atmContext, int pin) {
        return true; // Already validated
    }

    @Override
    public Transaction selectTransaction(ATMContext atmContext) {
        // For simplicity, create a transaction based on type
        // In real, might have a menu
        // Assume TransactionType.WITHDRAW for now
        Transaction transaction = new WithdrawTransaction(UUID.randomUUID(), TransactionType.WITHDRAW, TransactionStatus.IN_PROGRESS);
        atmContext.transaction = transaction;
        atmContext.atmState = new TransactionSelectedState();
        return transaction;
    }

    @Override
    public boolean processTransaction(ATMContext atmContext) {
        return false; // Need to select first
    }

    @Override
    public boolean ejectCard(ATMContext atmContext) {
        atmContext.currentCard = null;
        atmContext.atmState = new IdleState();
        return true;
    }
}
