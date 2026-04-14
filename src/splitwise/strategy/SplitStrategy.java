package splitwise.strategy;

import splitwise.entity.User;
import java.util.*;

public interface SplitStrategy {
    Map<User, Double> splitExpense(List<User> participants, double totalAmount);
}

