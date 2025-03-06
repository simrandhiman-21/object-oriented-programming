import java.util.*;
// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    private static final double TAX_RATE = 0.18;
    
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Electronics Tax: " + calculateTax();
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private static final double TAX_RATE = 0.05;
    
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Clothing Tax: " + calculateTax();
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class to demonstrate polymorphism
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics product1 = new Electronics(201, "Laptop", 1000);
        Clothing product2 = new Clothing(202, "T-Shirt", 50);
        Groceries product3 = new Groceries(203, "Apple", 2);
        
        products.add(product1);
        products.add(product2);
        products.add(product3);
        
        for (Product product : products) {
            product.displayDetails();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - product.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("--------------------------");
        }
    }
}