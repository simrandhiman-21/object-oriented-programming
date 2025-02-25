class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}


class Manager extends Employee {
    private String teamName;

   
    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

  
    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Accessing public member from parent class
        System.out.println("Department: " + department); // Accessing protected member from parent class
        System.out.println("Team Name: " + teamName);
    }

    public static void main(String[] args) {
        
        Employee emp1 = new Employee(101, "IT", 60000.0);
        emp1.displayEmployeeDetails();
        System.out.println();

        
        emp1.setSalary(65000.0);
        System.out.println("Updated Salary: $" + emp1.getSalary());
        System.out.println();

        
        Manager manager1 = new Manager(201, "HR", 90000.0, "Recruitment Team");
        manager1.displayManagerDetails();
    }
}
