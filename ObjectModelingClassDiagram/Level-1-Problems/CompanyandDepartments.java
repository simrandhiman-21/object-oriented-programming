import java.util.ArrayList;
import java.util.List;

// Employee class (part of a Department, cannot exist independently)
class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Employee: " + name);
    }
}

// Department class (part of a Company, cannot exist independently)
class Department {
    String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void display() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

// Company class (owns Departments and Employees, composition relationship)
class Company {
    String name;
    List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void display() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.display();
        }
    }
}

public class CompanyandDepartments {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("TechCorp");

        // Creating departments
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        // Adding employees to departments
        dept1.addEmployee(new Employee("Alice"));
        dept1.addEmployee(new Employee("Bob"));
        dept2.addEmployee(new Employee("Charlie"));

        // Adding departments to company
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Display company structure
        company.display();
    }
}
