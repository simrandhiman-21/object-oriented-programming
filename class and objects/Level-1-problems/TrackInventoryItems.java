import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackInventoryItems {

    int itemCode;
    String itemName;
    double price;


    TrackInventoryItems(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }


    public void displayItems(int quantity) {
        System.out.println("Item Code: " + itemCode + ", Item Name: " + itemName + ", Total Price: " + totalCost(quantity));
    }

    // Method to calculate total cost based on quantity
    public double totalCost(int quantity) {
        return quantity * price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TrackInventoryItems> inventory = new ArrayList<>(); 

        System.out.println("How many items do you want to enter?");
        int numberOfItems = sc.nextInt();
        sc.nextLine(); 

       
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter Item Code for item " + (i + 1) + ":");
            int itemCode = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter Item Name for item " + (i + 1) + ":");
            String itemName = sc.nextLine();

            System.out.println("Enter Price for item " + (i + 1) + ":");
            double price = sc.nextDouble();

            System.out.println("Enter Quantity for item " + (i + 1) + ":");
            int quantity = sc.nextInt();

            
            TrackInventoryItems item = new TrackInventoryItems(itemCode, itemName, price);
            inventory.add(item);

           
            item.displayItems(quantity);
        }

        // Close the scanner
        sc.close();
    }
}