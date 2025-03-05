

// Base class: Person
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    public void displayRole() {
        System.out.println("Role: Teacher");
        displayInfo();
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    private int grade;
    
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    
    public void displayRole() {
        System.out.println("Role: Student");
        displayInfo();
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String position;
    
    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }
    
    public void displayRole() {
        System.out.println("Role: Staff");
        displayInfo();
        System.out.println("Position: " + position);
    }
}

// Main class to test the hierarchy
public class SchoolSystemwithDifferentRoles {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 16, 10);
        Staff staff = new Staff("Charlie", 40, "Administrator");
        
        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}

