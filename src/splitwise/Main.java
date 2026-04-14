package splitwise;

import splitwise.entity.*;
import splitwise.strategy.SplitStrategy;
import splitwise.observer.Observer;
import splitwise.enums.Role;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Splitwise System Demo ===\n");

        // Create Users
        User alice = new User("user1", "Alice", "alice@email.com");
        User bob = new User("user2", "Bob", "bob@email.com");
        User charlie = new User("user3", "Charlie", "charlie@email.com");
        User diana = new User("user4", "Diana", "diana@email.com");

        System.out.println("Created Users: " + alice + ", " + bob + ", " + charlie + ", " + diana + "\n");

        // Create a group
        Group tripGroup = alice.createGroup("Trip to Vegas", "Vacation expense splitting");
        System.out.println("Created Group: " + tripGroup + "\n");

        // Add members to group
        tripGroup.addMember(bob, Role.MEMBER);
        tripGroup.addMember(charlie, Role.ADMIN);
        tripGroup.addMember(diana, Role.MEMBER);

        System.out.println("Added members to group: " + tripGroup.getMembers().size() + " members\n");

        // Add observers to group
        GroupNotifier groupNotifier = new GroupNotifier();
        tripGroup.addObserver(groupNotifier);

        // Create expenses
        System.out.println("--- Creating Expenses ---\n");

        // Alice pays $300 for hotel and splits equally among all 4
        SplitStrategy equalSplitStrategy = createEqualSplitStrategy();
        Expense hotelExpense = tripGroup.createExpense("Hotel", alice, 300, equalSplitStrategy);
        List<User> hotelParticipants = Arrays.asList(alice, bob, charlie, diana);
        hotelExpense.makeSplit(hotelParticipants);
        System.out.println("Hotel Expense: " + hotelExpense);
        System.out.println("Hotel Splits: " + hotelExpense.getSplits().size() + "\n");

        // Bob pays $120 for dinner and splits among alice, bob, charlie (not diana)
        Expense dinnerExpense = tripGroup.createExpense("Dinner", bob, 120, equalSplitStrategy);
        List<User> dinnerParticipants = Arrays.asList(alice, bob, charlie);
        dinnerExpense.makeSplit(dinnerParticipants);
        System.out.println("Dinner Expense: " + dinnerExpense);
        System.out.println("Dinner Splits: " + dinnerExpense.getSplits().size() + "\n");

        // Print group summary
        System.out.println("--- Group Summary ---\n");
        System.out.println("Group Balance for Alice: $" + tripGroup.getGroupBalance(alice));
        System.out.println("Group Balance for Bob: $" + tripGroup.getGroupBalance(bob));
        System.out.println("Group Balance for Charlie: $" + tripGroup.getGroupBalance(charlie));
        System.out.println("Group Balance for Diana: $" + tripGroup.getGroupBalance(diana));
        System.out.println();

        // Check unpaid splits
        System.out.println("--- Unpaid Splits ---\n");
        System.out.println("Alice's unpaid splits: " + alice.getUnpaidSplits().size());
        System.out.println("Bob's unpaid splits: " + bob.getUnpaidSplits().size());
        System.out.println("Charlie's unpaid splits: " + charlie.getUnpaidSplits().size());
        System.out.println("Diana's unpaid splits: " + diana.getUnpaidSplits().size());
        System.out.println();

        // Create friendship and add transactions
        System.out.println("--- Friendship & Transactions ---\n");
        alice.addFriendship(bob);
        Friendship aliceBobFriendship = alice.getFriendships().get(alice.getUserId() + "_" + bob.getUserId());
        
        if (aliceBobFriendship != null) {
            aliceBobFriendship.makeTransaction(bob, alice, 50, "Coffee payment");
            System.out.println("Friendship: " + aliceBobFriendship);
            System.out.println("Net Balance (requester - requestee): $" + aliceBobFriendship.getNetBalance());
            System.out.println("Transactions: " + aliceBobFriendship.getTransactions().size());
        }
        System.out.println();

        // Settle a split
        System.out.println("--- Settlement ---\n");
        Split firstSplit = (Split) hotelExpense.getSplits().values().toArray()[0];
        if (firstSplit != null) {
            System.out.println("Before Settlement: " + firstSplit);
            firstSplit.settle();
            System.out.println("After Settlement: " + firstSplit);
            System.out.println("Alice's remaining unpaid splits: " + alice.getUnpaidSplits().size());
        }
        System.out.println();

        // Check user's total amounts
        System.out.println("--- User Financial Summary ---\n");
        System.out.println("Alice's total owed: $" + alice.getTotalAmountOwed());
        System.out.println("Bob's total owed: $" + bob.getTotalAmountOwed());
        System.out.println("Charlie's total owed: $" + charlie.getTotalAmountOwed());
        System.out.println("Diana's total owed: $" + diana.getTotalAmountOwed());
        System.out.println();

        // Demonstrate permissions
        System.out.println("--- Permissions Check ---\n");
        GroupMembership aliceMembership = tripGroup.getMembers().get(alice.getUserId());
        GroupMembership charlieeMembership = tripGroup.getMembers().get(charlie.getUserId());
        
        System.out.println("Alice (OWNER) can modify group: " + aliceMembership.canModifyGroup());
        System.out.println("Alice (OWNER) can delete group: " + aliceMembership.canDeleteGroup());
        System.out.println("Charlie (ADMIN) can modify group: " + charlieeMembership.canModifyGroup());
        System.out.println("Charlie (ADMIN) can delete group: " + charlieeMembership.canDeleteGroup());
    }

    // Helper method to create equal split strategy
    private static SplitStrategy createEqualSplitStrategy() {
        return new SplitStrategy() {
            @Override
            public Map<User, Double> splitExpense(List<User> participants, double totalAmount) {
                Map<User, Double> splits = new HashMap<>();
                double sharePerPerson = totalAmount / participants.size();
                for (User user : participants) {
                    splits.put(user, sharePerPerson);
                }
                return splits;
            }
        };
    }
}

// Simple observer implementation for demo
class GroupNotifier implements Observer {
    @Override
    public void notify(String message) {
        System.out.println("[GROUP NOTIFICATION] " + message);
    }
}

