package splitwise.entity;

import splitwise.enums.TransactionStatus;
import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private User fromUser;      // payer
    private User toUser;        // payee
    private double amount;
    private String description;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public Transaction(String transactionId, User fromUser, User toUser, double amount, String description, TransactionStatus status) {
        this.transactionId = transactionId;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.completedAt = status == TransactionStatus.COMPLETED ? LocalDateTime.now() : null;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    // Core Methods
    public void markAsCompleted() {
        if (status == TransactionStatus.PENDING) {
            this.status = TransactionStatus.COMPLETED;
            this.completedAt = LocalDateTime.now();
        }
    }

    public void markAsFailed() {
        this.status = TransactionStatus.FAILED;
    }

    public boolean isPending() {
        return status == TransactionStatus.PENDING;
    }

    public boolean isCompleted() {
        return status == TransactionStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", fromUser=" + fromUser.getName() +
                ", toUser=" + toUser.getName() +
                ", amount=" + amount +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}

