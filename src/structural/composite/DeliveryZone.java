package structural.composite;

import java.util.List;

public class DeliveryZone implements ECommerceDeliveryHub{
    private List<DeliveryHub> deliveryHubs;

    @Override
    public int trackPackages() {
        int ordersToDeliver = 0;

        for (DeliveryHub i : deliveryHubs) {
            ordersToDeliver += i.trackPackages();
        }

        return ordersToDeliver;
    }
}
