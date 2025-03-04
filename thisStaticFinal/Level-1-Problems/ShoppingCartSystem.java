class Product {
    // Static variable shared by all products
    private static double discount = 10.0; // Default discount in percentage

    // Final variable to ensure product ID cannot be changed
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this' to resolve ambiguity
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update the discount percentage
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Method to display product details
    public void displayProductDetails() {
        if (this instanceof Product) { // Using instanceof
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price After Discount: $" + discountedPrice);
        } else {
            System.out.println("Invalid Product Entry.");
        }
    }

    public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Creating product objects
        Product prod1 = new Product(101, "Laptop", 1200.0, 2);
        Product prod2 = new Product(102, "Smartphone", 800.0, 1);

        // Displaying product details before updating discount
        prod1.displayProductDetails();
        System.out.println();
        prod2.displayProductDetails();
        System.out.println();

        // Updating the discount
        Product.updateDiscount(15.0);
        System.out.println();

        // Displaying product details after updating discount
        prod1.displayProductDetails();
        System.out.println();
        prod2.displayProductDetails();
    }
}
}
