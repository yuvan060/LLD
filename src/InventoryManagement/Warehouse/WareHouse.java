package InventoryManagement.Warehouse;

import InventoryManagement.Product.Product;
import InventoryManagement.Stock.Stock;
import InventoryManagement.Stock.StockBatch;
import InventoryManagement.Stock.StockPickingStrategy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WareHouse {
    public final int id;
    public final String location;
    public final int geoIndex;
    public final ConcurrentHashMap<String, Stock> stocks;

    public WareHouse(int geoIndex, String location, int id) {
        this.geoIndex = geoIndex;
        this.location = location;
        this.id = id;
        this.stocks = new ConcurrentHashMap<>();
    }

    public StockBatch addItem(String sku, Product product, long quantity) {
        if(!stocks.containsKey(sku)) {
            stocks.put(sku, new Stock(product, sku));
        }
        StockBatch stockBatch = new StockBatch(quantity, new Date());
        stocks.get(sku).addStock(stockBatch);
        return stockBatch;
    }

    public StockBatch retrieveStock(long quantity, String sku) {
        if(!stocks.containsKey(sku)) {
            throw new RuntimeException("Couldn't found stocks with this sku");
        }
        return stocks.get(sku).retrieveStock(quantity);
    }
}
