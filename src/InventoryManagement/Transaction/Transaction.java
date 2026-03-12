package InventoryManagement.Transaction;


import InventoryManagement.Stock.StockBatch;

interface TransactionState {
    void processNextTransaction(Transaction transaction);
}

public class Transaction {
    public final TRANSACTION_TYPE transactionType;
    public final long quantity;
    public TransactionState transactionState;
    public final String sku;
    public final StockBatch stockBatch;

    public Transaction(TRANSACTION_TYPE transactionType, long quantity, String sku, StockBatch stockBatch) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.sku = sku;
        this.stockBatch = stockBatch;
    }

    public void nextStep() {
        transactionState.processNextTransaction(this);
    }
}
