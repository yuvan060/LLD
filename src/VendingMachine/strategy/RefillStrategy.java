package VendingMachine.strategy;

import VendingMachine.Inventory.Inventory;
import VendingMachine.Product.Product;

import java.util.List;

public interface RefillStrategy {
    public void refill(Inventory inventory, List<Product> productList);
}
