package InventoryManagement;

import InventoryManagement.Product.Product;
import InventoryManagement.Stock.StockBatch;
import InventoryManagement.Transaction.TRANSACTION_TYPE;
import InventoryManagement.Transaction.Transaction;
import InventoryManagement.Warehouse.WareHouse;
import InventoryManagement.Warehouse.WareHousePickingStrategy;
import InventoryManagement.Warehouse.WareHouseStockRetrievalStrategy;

import java.util.List;

public class InventorySystem {

    public final List<WareHouse> wareHouses;
    public WareHouseStockRetrievalStrategy wareHouseStockRetrievalStrategy;
    public WareHousePickingStrategy wareHousePickingStrategy;
    public final List<Transaction> transactions;

    public InventorySystem(List<WareHouse> wareHouses, List<Transaction> transactions) {
        this.wareHouses = wareHouses;
        this.transactions = transactions;
        this.wareHouseStockRetrievalStrategy = List::getLast;
        this.wareHousePickingStrategy = (wareHouses1, requestGeoIndex) -> wareHouses.getFirst();
    }

    public void addProduct(Product product, long quantity, String sku,int requestGeoIndex) {
        WareHouse wareHouse = wareHousePickingStrategy.pickWareHouse(wareHouses, requestGeoIndex);
        StockBatch stockBatch = wareHouse.addItem(sku, product, quantity);
        Transaction transaction = new Transaction(TRANSACTION_TYPE.ADD, quantity, sku, stockBatch);
        transactions.add(transaction);
    }

    public boolean retrieveProduct(String sku, long quantity) {
        //we can add geoIndex then pass it to strategy to pick nearest one
        WareHouse wareHouse = wareHouseStockRetrievalStrategy.retrievalWareHouse(wareHouses);
        StockBatch stockBatch = wareHouse.retrieveStock(quantity, sku);
        if(stockBatch == null) return  false;
        Transaction transaction = new Transaction(TRANSACTION_TYPE.RETRIEVE, quantity, sku, stockBatch);
        transactions.add(transaction);
        return true;
    }
}
