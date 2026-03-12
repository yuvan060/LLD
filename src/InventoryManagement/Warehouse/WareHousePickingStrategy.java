package InventoryManagement.Warehouse;

import java.util.List;

public interface WareHousePickingStrategy {
    WareHouse pickWareHouse(List<WareHouse> wareHouses, int requestGeoIndex);
}
