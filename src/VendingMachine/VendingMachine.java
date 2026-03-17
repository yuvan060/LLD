package VendingMachine;

public class VendingMachine {
    /*
    Design a vending machine that has Many slots, each slot can hold fixed number of
    items, the items has price, exp_date, load_date
    The vendingMachine should take the order, order may have single or multiple products of any quantity(available)
    Once the order is decided checkOut the order, handle payment
    And a slot can be refilled when it is empty or partially empty.

    Entities -

    Product - name, price, loadDate, expDate
    Slot - Queue<Product>, id, maxCapacity; addItem(), checkOutItem(), isFull(), isEmpty()
    Inventory - Map<Item, List<Slot>>, refillStrategy; checkOutItem(Product, quantity)
    Order - id, Map<Item, Integer(quantity)>, paymentStrategy, orderState, double amount;
             addItem(), addQuantity(), checkOutOrder(), cancelOrder()
    VendingMachine - id, List<Order>, machineState, currentOrder, Inventory;
                       createOrder(), addItem(), removeItem(), processOrder()

    enum OrderState - createdState, PaymentState, CompleteState, CancelledState, FailedState
    MachineState - IdleState, ProcessingOrder, Maintenance, OutOfService



    */
}
