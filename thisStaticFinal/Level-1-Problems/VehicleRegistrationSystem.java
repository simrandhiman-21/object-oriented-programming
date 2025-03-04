class Vehicle {
    // Static variable shared by all vehicles
        private static double registrationFee = 500.0; // Default fee in dollars
        
        // Final variable to ensure registration number cannot be changed
        private final String registrationNumber;
        private String ownerName;
        private String vehicleType;
        
        // Constructor using 'this' to resolve ambiguity
        public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
            this.registrationNumber = registrationNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }
    
        // Static method to update the registration fee
        public static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: $" + registrationFee);
        }
    
        // Method to display vehicle registration details
        public void displayVehicleDetails() {
            if (this instanceof Vehicle) { // Using instanceof
                System.out.println("Owner Name: " + ownerName);
                System.out.println("Vehicle Type: " + vehicleType);
                System.out.println("Registration Number: " + registrationNumber);
                System.out.println("Registration Fee: $" + registrationFee);
            } else {
                System.out.println("Invalid Vehicle Entry.");
            }
        }
        
    public class VehicleRegistrationSystem {
        public static void main(String[] args) {
            // Creating vehicle objects
            Vehicle car = new Vehicle("AB1234", "Alice Johnson", "Car");
            Vehicle bike = new Vehicle("XY5678", "Bob Smith", "Motorbike");
    
            // Displaying vehicle details before updating registration fee
            car.displayVehicleDetails();
            System.out.println();
            bike.displayVehicleDetails();
            System.out.println();
    
            // Updating the registration fee
            Vehicle.updateRegistrationFee(600.0);
            System.out.println();
    
            // Displaying vehicle details after updating registration fee
            car.displayVehicleDetails();
            System.out.println();
            bike.displayVehicleDetails();
        }
    }
    
}
