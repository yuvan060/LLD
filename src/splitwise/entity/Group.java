package splitwise.entity;

import splitwise.observer.Observer;
import splitwise.strategy.SplitStrategy;
import splitwise.enums.Role;
import java.time.LocalDateTime;
import java.util.*;

public class Group {
    private final String groupId;
    private final String groupName;
    private String description;
    private final User createdBy;
    private final LocalDateTime createdAt;
    private final Map<String, GroupMembership> members; // userId -> GroupMembership
    private final Map<String, Expense> expenses; // expenseId -> Expense
    private final List<Observer> groupObservers;

    public Group(String groupId, String groupName, String description, User createdBy) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.members = new HashMap<>();
        this.expenses = new HashMap<>();
        this.groupObservers = new ArrayList<>();

        // Add creator as owner
        addMember(createdBy, Role.OWNER);
    }

    // Getters
    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Map<String, GroupMembership> getMembers() {
        return members;
    }

    public Map<String, Expense> getExpenses() {
        return expenses;
    }

    // Core Methods
    public void addMember(User user, Role role) {
        if (!members.containsKey(user.getUserId())) {
            GroupMembership membership = new GroupMembership(user, this, role);
            members.put(user.getUserId(), membership);
            user.getGroups().put(groupId, this);
            notifyObservers("User " + user.getName() + " added to group as " + role);
        }
    }

    public void removeMember(User user) {
        if (members.containsKey(user.getUserId())) {
            members.remove(user.getUserId());
            user.getGroups().remove(groupId);
            notifyObservers("User " + user.getName() + " removed from group");
        }
    }

    public boolean isMember(User user) {
        return members.containsKey(user.getUserId());
    }

    public Expense createExpense(String expenseName, User paidBy, double amount, SplitStrategy splitStrategy) {

        Expense expense = new Expense(
                UUID.randomUUID().toString(),
                expenseName,
                this,
                paidBy,
                amount,
                splitStrategy
        );
        expenses.put(expense.getExpenseId(), expense);
        notifyObservers("Expense created: " + expenseName + " of amount " + amount);
        return expense;
    }

    public void deleteExpense(String expenseId) {
        // TODO: Handle cascading - remove all associated splits
        Expense expense = expenses.remove(expenseId);
        if (expense != null) {
            notifyObservers("Expense deleted: " + expense.getExpenseName());
        }
    }

    public double getGroupBalance(User user) {
        // Calculate total amount user owes or is owed within this group
        double balance = 0;
        for (Expense expense : expenses.values()) {
            // Check splits related to this user
            for (Split split : expense.getSplits().values()) {
                if (split.getOwedBy().getUserId().equals(user.getUserId())) {
                    balance -= split.getAmount();
                } else if (split.getOwedTo().getUserId().equals(user.getUserId())) {
                    balance += split.getAmount();
                }
            }
        }
        return balance;
    }

    public void addObserver(Observer observer) {
        groupObservers.add(observer);
    }

    public void removeObserver(Observer observer) {
        groupObservers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : groupObservers) {
            observer.notify(message);
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", members=" + members.size() +
                '}';
    }
}


