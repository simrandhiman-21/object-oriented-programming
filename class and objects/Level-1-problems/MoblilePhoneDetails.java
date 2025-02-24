import java.util.*;
class Phone { 
    private String brand;
    private String model;
    private double price;

    // Constructor to initialize phone details
    public Phone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    public void display() {
        System.out.println("Brand Name: " + brand + ", Model: " + model + ", Price: " + price);
    }

    // // Getters for the attributes (optional)
    // public String getBrand() {
    //     return brand;
    // }

    // public String getModel() {
    //     return model;
    // }

    // public double getPrice() {
    //     return price;
    // }
}
public class MoblilePhoneDetails {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
        List<Phone> phoneList = new ArrayList<>();

        System.out.println("How many mobile phones do you want to enter?");
        int numberOfPhones = sc.nextInt();
        sc.nextLine();

        // Loop to input multiple mobile phones
        for (int i = 0; i < numberOfPhones; i++) {
            System.out.println("Enter Brand Name for phone " + (i + 1) + ": ");
            String brand = sc.nextLine();

            System.out.println("Enter Model Name for phone " + (i + 1) + ": ");
            String model = sc.nextLine();

            System.out.println("Enter Price for phone " + (i + 1) + ": ");
            double price = sc.nextDouble();
            sc.nextLine(); 
            // Create an instance of Phone and add it to the list
            Phone phone = new Phone(brand, model, price);
            phoneList.add(phone);
        }

        // Display all mobile phone details
        System.out.println("\nMobile Phone Details:");
        for (Phone phone : phoneList) {
            phone.display();
        }

       
    }
}
