package VendingMachine.Vending;

import VendingMachine.Product.Product;

public interface VendingMachineState {
    /*
    This abstract class is implemented by IdleState, ProcessingOrderState, MaintenanceState, OutOfServiceState
     */
    boolean addProductToOrder(VendingMachine vendingMachine, Product product, int quantity);
    boolean removeProductFromOrder(VendingMachine vendingMachine, Product product, int quantity);
    boolean processOrder(VendingMachine vendingMachine);
    boolean cancelOrder(VendingMachine vendingMachine);
    boolean createOrder(VendingMachine vendingMachine);
    boolean putMaintenance(VendingMachine vendingMachine);
}
