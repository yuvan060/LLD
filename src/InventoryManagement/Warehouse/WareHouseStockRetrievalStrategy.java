package InventoryManagement.Warehouse;

import java.util.List;

public interface WareHouseStockRetrievalStrategy {
    WareHouse retrievalWareHouse(List<WareHouse> wareHouses);
}
