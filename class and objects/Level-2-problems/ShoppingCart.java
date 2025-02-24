import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

   
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addToCart(int quantityToAdd) {
        this.quantity += quantityToAdd;
        System.out.println(quantityToAdd + " of " + itemName + " added to the cart.");
    }

    
    public void removeFromCart(int quantityToRemove) {
        if (quantityToRemove > quantity) {
            System.out.println("Cannot remove more than available. Current quantity: " + quantity);
        } else {
            this.quantity -= quantityToRemove; 
            System.out.println(quantityToRemove + " of " + itemName + " removed from the cart.");
        }
    }

    
    public double totalCost() {
        return price * quantity; 
    }

   
    public void display() {
        System.out.println("Item Name: " + itemName + ", Quantity: " + quantity + ", Price: $" + price);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter Item Name: ");
        String itemName = sc.nextLine();

        System.out.println("Enter Price: ");
        double price = sc.nextDouble();

        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        // Create a CartItem object
        CartItem cartItem = new CartItem(itemName, price, quantity);

        // Add items to the cart
        System.out.println("How many items do you want to add to the cart?");
        int quantityToAdd = sc.nextInt();
        cartItem.addToCart(quantityToAdd);

        // Remove items from the cart
        System.out.println("How many items do you want to remove from the cart?");
        int quantityToRemove = sc.nextInt();
        cartItem.removeFromCart(quantityToRemove);

        // Display item details and total cost
        cartItem.display();
        System.out.println("Total Cost: $" + cartItem.totalCost());

          }
}