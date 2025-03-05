// Base class: Order
class Order {
    protected String orderId;
    protected String orderDate;
    
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    protected String trackingNumber;
    
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + ", Shipped with tracking number: " + trackingNumber;
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + ", Delivered on: " + deliveryDate;
    }
}

// Main class to test the hierarchy
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD123", "2025-03-01");
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", "2025-03-02", "TRK5678");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", "2025-03-03", "TRK91011", "2025-03-05");
        
        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
