import java.util.*;
// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
    
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.02;
    private String insurancePolicyNumber;
    
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: [Protected]";
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.05;
    private String insurancePolicyNumber;
    
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // 20% surcharge for trucks
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: [Protected]";
    }
}

// Main class to demonstrate polymorphism
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car vehicle1 = new Car("C123", 50, "INS12345");
        Bike vehicle2 = new Bike("B456", 20);
        Truck vehicle3 = new Truck("T789", 100, "INS67890");
        
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            int rentalDays = 5;
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: " + ((Insurable) vehicle).calculateInsurance());
            }
            System.out.println("--------------------------");
        }
    }
}