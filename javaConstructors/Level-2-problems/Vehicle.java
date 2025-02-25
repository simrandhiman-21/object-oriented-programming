
public class Vehicle {

    private String ownerName;
    private String vehicleType;
    public static double registrationFee=100.0;

    Vehicle(String ownerName,String vehicleType){
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
    }

    public void displayVehicleDetails(){
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double fee){
        registrationFee = fee;
    }

    public static void main(String[] args) {

        Vehicle car=new Vehicle("John Doe","Car");
        car.displayVehicleDetails();

        Vehicle bus=new Vehicle("Alex", "Bus");
        bus.displayVehicleDetails();

        bus.updateRegistrationFee(150.0);

        car.displayVehicleDetails();
        bus.displayVehicleDetails();

        
    }
}
