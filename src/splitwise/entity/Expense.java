package splitwise.entity;

import splitwise.observer.Observer;
import splitwise.strategy.SplitStrategy;
import java.time.LocalDateTime;
import java.util.*;

public class Expense {
    private final String expenseId;
    private final String expenseName;
    private final Group group;
    private final User paidBy;
    private final double amount;
    private SplitStrategy splitStrategy;
    private final Map<String, Split> splits; // splitId -> Split
    private final List<Observer> expenseObservers;
    private final LocalDateTime createdAt;

    public Expense(String expenseId, String expenseName, Group group, User paidBy, double amount, SplitStrategy splitStrategy) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.group = group;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitStrategy = splitStrategy;
        this.splits = new HashMap<>();
        this.expenseObservers = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public String getExpenseId() {
        return expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Group getGroup() {
        return group;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public Map<String, Split> getSplits() {
        return splits;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Core Methods
    public void makeSplit(List<User> participantUsers) {
        // Use strategy pattern to split the expense
        // Strategy will calculate how much each user owes based on strategy type
        Map<User, Double> splitAmounts = splitStrategy.splitExpense(participantUsers, amount);

        // Create Split objects for each participant
        for (User participant : participantUsers) {
            if (!participant.getUserId().equals(paidBy.getUserId())) {
                Double owedAmount = splitAmounts.getOrDefault(participant, 0.0);
                if (owedAmount > 0) {
                    Split split = new Split(
                            UUID.randomUUID().toString(),
                            this,
                            participant, // owedBy
                            paidBy,      // owedTo
                            owedAmount
                    );
                    splits.put(split.getSplitId(), split);
                    participant.addUnpaidSplit(split);
                    notifyObservers("Split created for " + participant.getName() + " owing " + owedAmount);
                }
            }
        }

        // Validate total splits equal expense amount
        validateSplits();
    }

    private void validateSplits() {
        // TODO: Ensure that total split amounts = expense amount
        double totalSplits = splits.values().stream()
                .mapToDouble(Split::getAmount)
                .sum();

        if (Math.abs(totalSplits - amount) > 0.01) {
            System.err.println("Warning: Split amounts don't match expense amount. Total: " + totalSplits + ", Expected: " + amount);
        }
    }

    public void addSplit(Split split) {
        splits.put(split.getSplitId(), split);
    }

    public void removeSplit(String splitId) {
        Split split = splits.remove(splitId);
        if (split != null) {
            split.getOwedBy().removeUnpaidSplit(splitId);
        }
    }

    public void addObserver(Observer observer) {
        expenseObservers.add(observer);
    }

    public void removeObserver(Observer observer) {
        expenseObservers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : expenseObservers) {
            observer.notify(message);
        }
    }

    public double getExpenseStatus() {
        double settled = splits.values().stream()
                .filter(Split::isSettled)
                .mapToDouble(Split::getAmount)
                .sum();
        return (settled / amount) * 100;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId='" + expenseId + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", paidBy=" + paidBy.getName() +
                ", amount=" + amount +
                ", splits=" + splits.size() +
                '}';
    }
}

