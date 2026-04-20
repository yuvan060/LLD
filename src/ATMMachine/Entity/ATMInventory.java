package ATMMachine.Entity;

import ATMMachine.ENUM.MONEY;

import java.util.LinkedHashMap;
import java.util.Map;

public class ATMInventory {
    private final Map<MONEY, Integer> cashInventory;

    private ATMInventory() {
        this.cashInventory = new LinkedHashMap<>();
    }

    public void dispenseMoney(int amount) {
        // Simple greedy approach, assuming denominations allow exact
        for (MONEY m : cashInventory.keySet()) {
            int count = amount / m.getValue();
            if (count > 0 && cashInventory.get(m) >= count) {
                amount -= count * m.getValue();
                cashInventory.put(m, cashInventory.get(m) - count);
            }
        }
        if (amount > 0) {
            // Cannot dispense exact, but for now, ignore
        }
    }

    public boolean canWithdrawCash(int amount) {
        // Simple check: if total cash >= amount, assume can dispense
        int total = 0;
        for (Map.Entry<MONEY, Integer> entry : cashInventory.entrySet()) {
            total += entry.getKey().getValue() * entry.getValue();
        }
        return total >= amount;
    }

    public void fillMoney(Map<MONEY, Integer> money) {
        for(MONEY m : money.keySet()) {
            cashInventory.put(m, cashInventory.getOrDefault(m, 0) + money.get(m));
        }
    }

    private static class ATMInventoryInstanceHolder {
        private static final ATMInventory atmInventory = new ATMInventory();

        public static ATMInventory getAtmInventory() {
            return atmInventory;
        }
    }

    public static ATMInventory getInstance() {
        return ATMInventoryInstanceHolder.getAtmInventory();
    }
}
