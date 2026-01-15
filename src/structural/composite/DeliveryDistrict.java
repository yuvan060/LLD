package structural.composite;

import java.util.List;

public class DeliveryDistrict implements ECommerceDeliveryHub{
    private List<DeliveryZone> deliveryZones;
    @Override
    public int trackPackages() {
        int ordersToDeliver = 0;
        for(DeliveryZone i : deliveryZones) {
            ordersToDeliver += i.trackPackages();
        }
        return ordersToDeliver;
    }
}
