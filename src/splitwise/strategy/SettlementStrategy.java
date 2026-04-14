package splitwise.strategy;

import splitwise.entity.User;
import splitwise.entity.Transaction;

public interface SettlementStrategy {
    boolean canSettle(User user1, User user2);
    Transaction settle(User user1, User user2, double amount);
}

