package structural.composite;

public class DeliveryHub implements ECommerceDeliveryHub{
    private int ordersToDeliver;
    @Override
    public int trackPackages() {
        return ordersToDeliver;
    }
}
