import java.util.ArrayList;
import java.util.List;

// Product class (Represents individual products in the system)
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}

// Order class (Aggregates multiple Product objects)
class Order {
    int orderId;
    List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in this order:");
        for (Product product : products) {
            product.display();
        }
    }
}

// Customer class (Associates with multiple Orders)
class Customer {
    String name;
    List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Customer: " + name + " has placed the following orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

// E-commerce platform to manage customers and orders
public class Ecommerce {
    public static void main(String[] args) {
        // Creating products
        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Smartphone", 699.99);
        Product product3 = new Product("Headphones", 199.99);

        // Creating customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Creating orders
        Order order1 = new Order(101);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102);
        order2.addProduct(product3);

        // Customers placing orders
        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        // Displaying customer orders
        customer1.displayOrders();
        customer2.displayOrders();
    }
}
