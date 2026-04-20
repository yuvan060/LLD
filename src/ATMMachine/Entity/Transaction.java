package ATMMachine.Entity;

import ATMMachine.ENUM.TransactionStatus;
import ATMMachine.ENUM.TransactionType;

import java.util.UUID;

public abstract class Transaction {

    public final UUID transactionId;
    public final TransactionType transactionType;
    public TransactionStatus transactionStatus;

    public Transaction(UUID transactionId, TransactionType transactionType, TransactionStatus transactionStatus) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }

    public abstract boolean execute(ATMContext atmContext);
}
