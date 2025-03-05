// Superclass: Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed;
    
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;
    
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }
    
    public void charge() {
        System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }
    
    public void displayType() {
        System.out.println("Vehicle Type: Electric Vehicle");
        displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: PetrolVehicle (inherits from Vehicle, implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;
    
    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }
    
    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel Capacity: " + fuelCapacity + " liters");
    }
    
    public void displayType() {
        System.out.println("Vehicle Type: Petrol Vehicle");
        displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Main class to test the system
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 250, 60);
        
        ev.displayType();
        ev.charge();
        System.out.println();
        
        pv.displayType();
        pv.refuel();
    }
}
