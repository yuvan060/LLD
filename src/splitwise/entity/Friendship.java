package splitwise.entity;

import splitwise.enums.TransactionStatus;
import java.time.LocalDateTime;
import java.util.*;

public class Friendship {
    private final String friendshipId;
    private final User requester;
    private final User requestee;
    private final LocalDateTime createdAt;
    private final List<Transaction> transactions; // bilateral transactions

    public Friendship(String friendshipId, User requester, User requestee) {
        this.friendshipId = friendshipId;
        this.requester = requester;
        this.requestee = requestee;
        this.createdAt = LocalDateTime.now();
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getFriendshipId() {
        return friendshipId;
    }

    public User getRequester() {
        return requester;
    }

    public User getRequestee() {
        return requestee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Core Methods
    public void makeTransaction(User fromUser, User toUser, double amount, String description) {
        // Validate that transaction is between requester and requestee
        if (!isValidTransaction(fromUser, toUser)) {
            throw new RuntimeException("Transaction must be between friendship members");
        }

        Transaction transaction = new Transaction(
                UUID.randomUUID().toString(),
                fromUser,
                toUser,
                amount,
                description,
                TransactionStatus.COMPLETED
        );
        transactions.add(transaction);
    }

    private boolean isValidTransaction(User user1, User user2) {
        return (user1.equals(requester) && user2.equals(requestee)) ||
               (user1.equals(requestee) && user2.equals(requester));
    }

    public double getNetBalance() {
        // Calculate net balance between requester and requestee
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getFromUser().equals(requester)) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public List<Transaction> getSettledTransactions() {
        List<Transaction> settled = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.isCompleted()) {
                settled.add(transaction);
            }
        }
        return settled;
    }

    public List<Transaction> getPendingTransactions() {
        List<Transaction> pending = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.isPending()) {
                pending.add(transaction);
            }
        }
        return pending;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "friendshipId='" + friendshipId + '\'' +
                ", requester=" + requester.getName() +
                ", requestee=" + requestee.getName() +
                ", transactions=" + transactions.size() +
                '}';
    }
}



