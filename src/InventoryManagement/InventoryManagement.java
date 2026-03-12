package InventoryManagement;

public class InventoryManagement {
    /*
    We need to design Inventory Management System
    The system may have multiple warehouses, each warehouse may store multiple stocks of multiple products
    The system should be able to add multiple products to its warehouses
    and should be able to retrieve products from its warehouse.


    Entity : -
        Product : id, name , category, description, load
        StockBatch : sku, Product, quantity, loadDate, expiryDate
        Stock : List<StockBatch> ; addNewBatch(), retrieveBatch(strategy);
        WareHouse : id, location, Map<String, Stock> stocks, StockSelectionStrategy;
                    retrieveStocks(), addStock(), getStock();
        InventorySystem : List<WareHouses>, PickupStrategy, RefillStrategy, InventoryObserver, WareHouseSelectionStrategy, List<Transactions>

        Transactions : id, TYPE, quantity, product, status, transactionState

    ENUM : Category : FURNITURE, ELECTRONICS
            TRANSACTION_TYPE : ADD, RETRIEVE

    Interface : PickUpStrategy, RefillStrategy, InventoryObserver, TransactionState(state design pattern to handle state transitions)

    */
}