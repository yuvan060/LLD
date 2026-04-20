package ATMMachine.Entity;

import ATMMachine.ENUM.TransactionStatus;
import ATMMachine.ENUM.TransactionType;
import java.util.UUID;

public class WithdrawTransaction extends Transaction {

    private int amount;

    public WithdrawTransaction(UUID transactionId, TransactionType transactionType, TransactionStatus transactionStatus) {
        super(transactionId, transactionType, transactionStatus);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean execute(ATMContext atmContext) {
        // Logic to withdraw money
        return true;
    }
}
