package InventoryManagement.Stock;

import InventoryManagement.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    public final String sku;
    public final List<StockBatch> stocks;
    public final Product product;
    public StockPickingStrategy stockPickingStrategy;

    public Stock(Product product, String sku) {
        this.product = product;
        this.sku = sku;
        this.stocks = new ArrayList<>();
        this.stockPickingStrategy = (stockBatch, quantity) -> stockBatch.getFirst();
    }

    public void addStock(StockBatch stockBatch) {
        stocks.add(stockBatch);
    }

    public StockBatch retrieveStock(long quantity) {
        return stockPickingStrategy.pickStock(stocks, quantity);
    }
}
