// Superclass: Person
class Person {
    protected String name;
    protected int id;
    
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef (inherits from Person, implements Worker)
class Chef extends Person implements Worker {
    private String specialty;
    
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
    
    public void displayRole() {
        System.out.println("Role: Chef");
        displayInfo();
        System.out.println("Specialty: " + specialty);
    }
}

// Subclass: Waiter (inherits from Person, implements Worker)
class Waiter extends Person implements Worker {
    private int tablesAssigned;
    
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }
    
    public void displayRole() {
        System.out.println("Role: Waiter");
        displayInfo();
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}

// Main class to test the system
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Alice", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Bob", 102, 5);
        
        chef.displayRole();
        chef.performDuties();
        System.out.println();
        
        waiter.displayRole();
        waiter.performDuties();
    }
}
