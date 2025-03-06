import java.util.*;
// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary for full-time employees
    }
    
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;
    
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0); // Base salary not applicable
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class to demonstrate polymorphism
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 5000);
        emp1.assignDepartment("HR");
        
        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 80);
        emp2.assignDepartment("IT");
        
        employees.add(emp1);
        employees.add(emp2);
        
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            
        }
    }
}
