
class Student {
    // Static variable shared by all students
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    
    // Final variable to ensure rollNumber cannot be changed
    private final int rollNumber;
    private String name;
    private char grade;
    
    // Constructor using 'this' to resolve ambiguity
    public Student(int rollNumber, String name, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.grade = grade;
            totalStudents++; // Increment total students count
        }
        
        // Static method to display total students
        public static void displayTotalStudents() {
            System.out.println("Total Students Enrolled: " + totalStudents);
        }
        
        // Method to update student grade (only if it's a Student object)
        public void updateGrade(char newGrade) {
            if (this instanceof Student) { // Using instanceof
                this.grade = newGrade;
                System.out.println(name + "'s grade updated to: " + grade);
            } else {
                System.out.println("Invalid Student Entry.");
            }
        }
        
        // Method to display student details
        public void displayStudentDetails() {
            if (this instanceof Student) { // Using instanceof
                System.out.println("University: " + universityName);
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("Invalid Student Entry.");
            }
        }
        
    public class UniversityStudentManagement {
        public static void main(String[] args) {
            // Creating student objects
            Student student1 = new Student(101, "Alice Brown", 'A');
            Student student2 = new Student(102, "Bob Smith", 'B');
    
            // Displaying student details
            student1.displayStudentDetails();
            System.out.println();
            student2.displayStudentDetails();
            System.out.println();
    
            // Updating grade for student1
            student1.updateGrade('A');
            System.out.println();
    
            // Displaying total students enrolled
            Student.displayTotalStudents();
        }
    }
}
