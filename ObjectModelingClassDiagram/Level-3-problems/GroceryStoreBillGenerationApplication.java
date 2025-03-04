import java.util.ArrayList;
import java.util.List;

// Product class (Represents an item in the grocery store)
class Product {
    String name;
    double pricePerUnit;
    double quantity;

    public Product(String name, double pricePerUnit, double quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return pricePerUnit * quantity;
    }

    public void displayProduct() {
        System.out.println(name + " (" + quantity + " units at $" + pricePerUnit + " per unit) - Total: $" + getTotalPrice());
    }
}

// Customer class (Holds purchased products)
class Customer {
    String name;
    List<Product> cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void displayCart() {
        System.out.println("Customer: " + name + " has purchased:");
        for (Product product : cart) {
            product.displayProduct();
        }
    }
}

// BillGenerator class (Computes total bill for a customer)
class BillGenerator {
    public static double generateBill(Customer customer) {
        double total = 0;
        for (Product product : customer.cart) {
            total += product.getTotalPrice();
        }
        return total;
    }
}

// Grocery Store Bill Generation Application
public class GroceryStoreBillGenerationApplication {
    public static void main(String[] args) {
        // Creating customer
        Customer customer1 = new Customer("Alice");

        // Adding products
        customer1.addProduct(new Product("Apples", 3.0, 2)); // 2 kg at $3 per kg
        customer1.addProduct(new Product("Milk", 2.0, 1)); // 1 liter at $2 per liter

        // Display purchased products
        customer1.displayCart();

        // Generate and display total bill
        double totalBill = BillGenerator.generateBill(customer1);
        System.out.println("Total Bill: $" + totalBill);
    }
}
