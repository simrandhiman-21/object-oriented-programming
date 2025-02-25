
class CarRental{

    String customerName;
    String carModel;
    int rentalDays;
    private static final double DAILY_RATE = 50.0;

 // Default constructor
   CarRental(){
        this.customerName="Unknown";
        this.carModel="Standard";
        this.rentalDays=1;
   }
// Parameterized constructor
   CarRental( String customerName,String carModel,int rentalDays){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
   }
   
    // Method to calculate total rental cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    // Display rental details
    public void displayRentalInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
}



public class CarRentalSystem {
    public static void main(String[] args) {
        
    CarRental defaultRental = new CarRental();
    defaultRental.displayRentalInfo();

    System.out.println();

    // Using parameterized constructor
    CarRental customRental = new CarRental("John Doe", "Toyota Camry", 5);
    customRental.displayRentalInfo();
    
    }
}
