package VendingMachine.Slot;

import VendingMachine.Product.Product;

import java.util.*;

public class Slot {
    public final Queue<Product> products;
    public final int maxCapacity;
    public boolean isEmpty;
    public boolean isFull;

    public Slot(int maxCapacity, Comparator<Product> pickStrategy) {
        this.maxCapacity = maxCapacity;
        this.products = new PriorityQueue<>(pickStrategy);
        this.isEmpty = products.isEmpty();
        this.isFull = products.size() == maxCapacity;
    }

    public boolean addItem(Product product) {
        if(products.size() == maxCapacity) {
            return false;
        }
        return products.add(product);
    }

    public List<Product> dispenseItem(Integer quantity) {
        List<Product> productsList = new ArrayList<>();
        while(quantity-- != 0) {
            productsList.add(products.poll());
        }
        return productsList;
    }

    public Integer getAvailableProducts() {
        return products.size();
    }
}
