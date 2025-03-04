class Employee {
    // Static variable shared by all employees
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    
    // Final variable to ensure employee ID cannot be changed
    private final int id;
    private String name;
    private String designation;
    
    // Constructor using 'this' to resolve ambiguity
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++; // Increment total employees count
    }
    
    // Static method to display the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    
    // Method to display employee details
    public void displayEmployeeDetails() {
        if (this instanceof Employee) { // Using instanceof
            System.out.println("Company: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid Employee Entry.");
            }
        }
        
    public class EmployeeManagementSystem{
        public static void main(String[] args) {
            // Creating employee objects
            Employee emp1 = new Employee(101, "Alice Johnson", "Software Engineer");
            Employee emp2 = new Employee(102, "Bob Smith", "Project Manager");
    
            // Displaying employee details
            emp1.displayEmployeeDetails();
            System.out.println();
            emp2.displayEmployeeDetails();
            System.out.println();
    
            // Displaying total employees
            Employee.displayTotalEmployees();
        }
    }
}
    
