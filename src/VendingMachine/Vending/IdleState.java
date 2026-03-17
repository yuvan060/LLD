package VendingMachine.Vending;

import VendingMachine.Product.Product;

public class IdleState implements VendingMachineState{
    @Override
    public boolean addProductToOrder(VendingMachine vendingMachine, Product product, int quantity) {
        //cannot add product to order
        return false;
    }

    @Override
    public boolean removeProductFromOrder(VendingMachine vendingMachine, Product product, int quantity) {
        //cannot remove product
        return false;
    }

    @Override
    public boolean processOrder(VendingMachine vendingMachine) {
        //couldn't process as system is in idle state
        return false;
    }

    @Override
    public boolean cancelOrder(VendingMachine vendingMachine) {
        //couldn't cancel as system is in idle state
        return false;
    }

    @Override
    public boolean createOrder(VendingMachine vendingMachine) {
        //change the state of the vending machine and assign an order to current Order
        return true;
    }

    @Override
    public boolean putMaintenance(VendingMachine vendingMachine) {
        //change the machine state to maintenance
        return true;
    }
}
