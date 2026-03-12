package InventoryManagement.Stock;

import java.util.Date;

enum BATCH_STATUS {
    ACTIVE,
    EXPIRED,
    EMPTY
}

public class StockBatch {
    public long quantity;
    public final Date loadDate;
    public BATCH_STATUS batchStatus; // we can use state design pattern to handle the batch status.

    public StockBatch(long quantity, Date loadDate) {
        this.loadDate = loadDate;
        this.quantity = quantity;
        batchStatus = BATCH_STATUS.ACTIVE;
    }

    public long getQuantity() {
        return quantity;
    }

    public synchronized void retrieveQuantity(long need) {
        if(quantity < need) {
            throw new RuntimeException("Insufficient Stocks");
        }
        quantity-=need;
    }

}
