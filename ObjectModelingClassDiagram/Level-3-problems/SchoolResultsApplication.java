import java.util.ArrayList;
import java.util.List;

// Subject class (Aggregates multiple subjects for a student)
class Subject {
    String name;
    int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

// Student class (Holds multiple subjects)
class Student {
    String name;
    List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void displaySubjects() {
        System.out.println("Student: " + name + " has the following subjects:");
        for (Subject subject : subjects) {
            System.out.println("- " + subject.name + " (Marks: " + subject.marks + ")");
        }
    }
}

// GradeCalculator class (Computes grades based on marks)
class GradeCalculator {
    public static char calculateGrade(int marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }

    public static void displayGrades(Student student) {
        System.out.println("Grades for " + student.name + ":");
        for (Subject subject : student.subjects) {
            System.out.println(subject.name + " - Grade: " + calculateGrade(subject.marks));
        }
    }
}

// School Results Application
public class SchoolResultsApplication {
    public static void main(String[] args) {
        // Creating student
        Student student1 = new Student("John");

        // Adding subjects
        student1.addSubject(new Subject("Maths", 90));
        student1.addSubject(new Subject("Science", 85));

        // Displaying student subjects and grades
        student1.displaySubjects();
        GradeCalculator.displayGrades(student1);
    }
}
