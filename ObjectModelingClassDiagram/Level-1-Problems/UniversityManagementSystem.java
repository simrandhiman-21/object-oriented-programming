 
import java.util.ArrayList;
import java.util.List;

// Course class (Aggregates Students and Professors)
class Course {
    String name;
    Professor professor;
    List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.addCourse(this); // Ensure bidirectional association
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.name);
        }
    }
}

// Student class (Associates with multiple Courses)
class Student {
    String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("- " + course.name);
        }
    }
}

// Professor class (Associates with multiple Courses)
class Professor {
    String name;
    List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.assignProfessor(this); // Ensure bidirectional association
        }
    }

    public void displayCourses() {
        System.out.println("Professor: " + name + " is teaching:");
        for (Course course : courses) {
            System.out.println("- " + course.name);
        }
    }
}

// University Management System
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating professors
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Johnson");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        
        // Creating courses
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");

        // Assigning professors to courses
        prof1.assignCourse(course1);
        prof2.assignCourse(course2);

        // Enrolling students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        // Displaying details
        student1.displayCourses();
        student2.displayCourses();
        prof1.displayCourses();
        prof2.displayCourses();
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
