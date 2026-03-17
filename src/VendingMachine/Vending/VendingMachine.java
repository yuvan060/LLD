package VendingMachine.Vending;

import VendingMachine.Inventory.Inventory;
import VendingMachine.Order.Order;
import VendingMachine.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    public final List<Order> orders;
    public VendingMachineState machineState;
    public Order currentOrder;
    public final Inventory inventory;

    public VendingMachine() {
        this.orders = new ArrayList<>();
        this.currentOrder = null;
        this.machineState = new IdleState();
        this.inventory = Inventory.getInstance();
    }

    public boolean createOrder() {
        return machineState.createOrder(this);
    }

    public boolean addProductToOrder(Product product, int quantity) {
        return machineState.addProductToOrder(this, product, quantity);
    }

    public boolean removeProductFromOrder(Product product, int quantity) {
        return machineState.removeProductFromOrder(this, product, quantity);
    }

    public boolean processOrder() {
        return machineState.processOrder(this);
    }

    public boolean scheduleMaintenance() {
        return  machineState.putMaintenance(this);
    }
}
