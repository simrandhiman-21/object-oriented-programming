import java.util.ArrayList;
import java.util.List;

// Course class (Students can enroll in multiple courses, Association relationship)
class Course {
    String name;
    List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.enrollInCourse(this);
    }

    public void displayStudents() {
        System.out.println("Course: " + name);
        for (Student student : enrolledStudents) {
            System.out.println("Student: " + student.getName());
        }
    }
}

// Student class (Can enroll in multiple courses, Association relationship)
class Student {
    String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public String getName() {
        return name;
    }

    public void displayCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.name);
        }
    }
}

// School class (Aggregates Students, meaning Students can exist independently)
class School {
    String name;
    List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
        }
    }
}

public class SchoolsandStudents{
    public static void main(String[] args) {
        // Creating a school
        School school = new School("Greenwood High");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Adding students to school (Aggregation - School has students, but they exist independently)
        school.addStudent(student1);
        school.addStudent(student2);

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses (Association - Many-to-Many relationship)
        math.enrollStudent(student1);
        science.enrollStudent(student1);
        science.enrollStudent(student2);

        // Display information
        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        math.displayStudents();
        science.displayStudents();
    }
}
