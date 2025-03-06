import java.util.*;
// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public abstract double calculateFare(double distance);
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    private String location;
    
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public String getCurrentLocation() {
        return location;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8; // 20% cheaper than cars
    }
}

// Auto class
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% cheaper than cars
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        
        Car car = new Car("V001", "John Doe", 15);
        Bike bike = new Bike("V002", "Jane Smith", 10);
        Auto auto = new Auto("V003", "Mike Johnson", 12);
        
        rides.add(car);
        rides.add(bike);
        rides.add(auto);
        
        double distance = 10; // Example distance
        
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));
            
            if (ride instanceof GPS) {
                ((GPS) ride).updateLocation("Downtown");
                System.out.println("Updated Location: " + ((GPS) ride).getCurrentLocation());
            }
            System.out.println("--------------------------");
        }
    }
}