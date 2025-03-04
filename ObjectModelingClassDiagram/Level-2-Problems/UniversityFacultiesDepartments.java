    import java.util.ArrayList;
import java.util.List;

// Faculty class (Aggregation - Faculty can exist independently of University)
class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Faculty: " + name);
    }
}

// Department class (Composition - Departments cannot exist without a University)
class Department {
    String name;
    
    public Department(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Department: " + name);
    }
}

// University class (Owns Departments - Composition, Aggregates Faculty)
class University {
    String name;
    List<Department> departments;
    List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void display() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.display();
        }
        System.out.println("Faculties:");
        for (Faculty fac : faculties) {
            fac.display();
        }
    }
}

public class UniversityFacultiesDepartments {
    public static void main(String[] args) {
        // Creating university
        University university = new University("Global University");

        // Creating departments (Composition - Owned by University)
        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("Physics");
        university.addDepartment(dept1);
        university.addDepartment(dept2);

        // Creating faculties (Aggregation - Faculties exist independently)
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Display university structure
        university.display();
    }
}

    