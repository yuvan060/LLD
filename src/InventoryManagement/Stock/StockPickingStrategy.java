package InventoryManagement.Stock;

import java.util.List;

public interface StockPickingStrategy {
    StockBatch pickStock(List<StockBatch> stockBatch, long quantity);
}
