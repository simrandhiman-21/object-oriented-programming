import java.util.*;
// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public abstract double calculateTotalPrice();
    
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double discountRate);
    double getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 1.2; // 20% extra charge
    private double discount;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() * ADDITIONAL_CHARGE) - discount;
    }
    
    @Override
    public void applyDiscount(double discountRate) {
        discount = (getPrice() * getQuantity() * ADDITIONAL_CHARGE) * discountRate / 100;
    }
    
    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// Main class to demonstrate polymorphism
public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        VegItem item1 = new VegItem("Paneer Tikka", 150, 2);
        NonVegItem item2 = new NonVegItem("Chicken Biryani", 250, 1);
        
        order.add(item1);
        order.add(item2);
        
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10); // Apply 10% discount
                System.out.println("Discount Applied: " + ((Discountable) item).getDiscountDetails());
                System.out.println("Final Price after Discount: " + item.calculateTotalPrice());
            }
            System.out.println("--------------------------");
        }
    }
}