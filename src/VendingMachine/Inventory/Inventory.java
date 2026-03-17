package VendingMachine.Inventory;

import VendingMachine.Product.Product;
import VendingMachine.Slot.Slot;
import VendingMachine.strategy.RefillStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {
    public final Map<Integer, List<Slot>> vendingInventory;
    public RefillStrategy refillStrategy;

    private Inventory() {
        this.vendingInventory = new HashMap<>();
        this.refillStrategy = (inventory, productList) -> {
            System.out.println("Refilling");
        };
    }

    public List<Product> checkOutProduct(int productId, int quantity) {
        List<Product> products = new ArrayList<>();
        for(Slot slot : vendingInventory.get(productId)) {
            quantity -= Math.max(0, slot.getAvailableProducts()-quantity);
            products.addAll(slot.dispenseItem(Math.min(quantity, slot.getAvailableProducts())).stream().toList());
            if(quantity == 0) {
                return products;
            }
        }
        return products;
    }

    public Integer getAvailableProducts(int productId) {
        return vendingInventory.get(productId).stream()
                .mapToInt(Slot::getAvailableProducts)
                .sum();
    }

    public void refill(List<Product> products) {
        refillStrategy.refill(this, products);
    }

    private static class InventoryHolder {
        private static final Inventory inventoryInstance = new Inventory();

        public static  Inventory getInventoryInstance() {
            return inventoryInstance;
        }
    }

    public static Inventory getInstance() {
        return InventoryHolder.getInventoryInstance();
    }
}
