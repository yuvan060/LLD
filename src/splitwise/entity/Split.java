package splitwise.entity;

import splitwise.observer.Observer;
import splitwise.enums.TransactionStatus;
import java.time.LocalDateTime;
import java.util.*;

public class Split {
    private final String splitId;
    private final Expense expense;
    private final User owedBy;      // who owes
    private final User owedTo;       // who is owed to (paidBy)
    private double amount;
    private boolean isSettled;
    private LocalDateTime settledAt;
    private final List<Observer> splitObservers;

    public Split(String splitId, Expense expense, User owedBy, User owedTo, double amount) {
        this.splitId = splitId;
        this.expense = expense;
        this.owedBy = owedBy;
        this.owedTo = owedTo;
        this.amount = amount;
        this.isSettled = false;
        this.settledAt = null;
        this.splitObservers = new ArrayList<>();
    }

    // Getters
    public String getSplitId() {
        return splitId;
    }

    public Expense getExpense() {
        return expense;
    }

    public User getOwedBy() {
        return owedBy;
    }

    public User getOwedTo() {
        return owedTo;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public LocalDateTime getSettledAt() {
        return settledAt;
    }

    // Core Methods
    public void settle() {
        // TODO: Mark split as settled, create transaction record
        if (!isSettled) {
            this.isSettled = true;
            this.settledAt = LocalDateTime.now();
            
            // Create transaction record
            Transaction transaction = new Transaction(
                    UUID.randomUUID().toString(),
                    owedBy,
                    owedTo,
                    amount,
                    "Settlement for " + expense.getExpenseName(),
                    TransactionStatus.COMPLETED
            );
            
            // Remove from owedBy's unpaid splits
            owedBy.removeUnpaidSplit(splitId);
            
            notifyObservers("Split settled: " + owedBy.getName() + " paid " + owedTo.getName() + " " + amount);
        }
    }

    public void settlePartially(double partialAmount) {
        // TODO: Handle partial settlement
        if (partialAmount > 0 && partialAmount < amount && !isSettled) {
            double remainingAmount = amount - partialAmount;
            
            // Create transaction for partial payment
            Transaction transaction = new Transaction(
                    UUID.randomUUID().toString(),
                    owedBy,
                    owedTo,
                    partialAmount,
                    "Partial settlement for " + expense.getExpenseName(),
                    TransactionStatus.COMPLETED
            );
            
            // Update split amount to remaining
            this.amount = remainingAmount;
            
            notifyObservers("Partial settlement: " + owedBy.getName() + " paid " + owedTo.getName() + " " + partialAmount);
        }
    }

    public void addObserver(Observer observer) {
        splitObservers.add(observer);
    }

    public void removeObserver(Observer observer) {
        splitObservers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : splitObservers) {
            observer.notify(message);
        }
    }

    @Override
    public String toString() {
        return "Split{" +
                "splitId='" + splitId + '\'' +
                ", owedBy=" + owedBy.getName() +
                ", owedTo=" + owedTo.getName() +
                ", amount=" + amount +
                ", isSettled=" + isSettled +
                '}';
    }
}

