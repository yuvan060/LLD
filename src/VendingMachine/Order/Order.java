package VendingMachine.Order;

import CarRentalSystem.Strategy.PaymentProcessor;
import VendingMachine.Product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

enum OrderStatus {
    CREATED,
    SUCCESS,
    FAILED,
    CANCELLED
}

public class Order {
    public final int id;
    public final Map<String, Integer> orderMap;
    public double amount;
    public PaymentProcessor paymentProcessor;
    public OrderStatus orderStatus;

    public Order() {
        id = new Random().nextInt();
        orderMap = new HashMap<>();
        amount = 0;
        paymentProcessor = (amount) -> true;
        orderStatus = OrderStatus.CREATED;
    }

    public void addProduct(Product product) {
        orderMap.put(product.name, orderMap.getOrDefault(product.name, 0)+1);
    }

    public void addProduct(Product product, int quantity) {
        orderMap.put(product.name, orderMap.getOrDefault(product.name, 0)+quantity);
    }

    public void removeProduct(Product product, int quantity) {
        orderMap.put(product.name, orderMap.getOrDefault(product.name, 0)-quantity);
        if(orderMap.get(product.name) <= 0) orderMap.remove(product.name);
    }

    public void removeProduct(Product product) {
        orderMap.remove(product.name);
    }

    public void cancelOrder() {
        orderStatus = OrderStatus.CANCELLED;
    }

    private double calculateAmount() {
        return 0;
    }

    public boolean checkOutOrder() {
        if(!paymentProcessor.processPayment(calculateAmount())) {
            orderStatus = OrderStatus.FAILED;
            return false;
        }
        orderStatus = OrderStatus.SUCCESS;
        return true;
    }
}
