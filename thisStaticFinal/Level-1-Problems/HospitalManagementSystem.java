class Patient {
    // Static variable shared among all patients
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;
    
    // Final variable to ensure patient ID cannot be changed
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    
    // Constructor using 'this' to resolve ambiguity
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increment total patients count
    }
    
    // Static method to get total patients
    public static int getTotalPatients() {
        return totalPatients;
    }
    
    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) { // Using instanceof
            System.out.println("Hospital: " + hospitalName);
                System.out.println("Patient ID: " + patientID);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Ailment: " + ailment);
            } else {
                System.out.println("Invalid Patient Entry.");
            }
        }
        
    public class HospitalManagementSystem {
        public static void main(String[] args) {
            // Creating patient objects
            Patient patient1 = new Patient(101, "Alice Brown", 45, "Flu");
            Patient patient2 = new Patient(102, "Bob Smith", 30, "Fever");
    
            // Displaying patient details
            patient1.displayPatientDetails();
            System.out.println();
            patient2.displayPatientDetails();
            System.out.println();
    
            // Displaying total number of patients admitted
            System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
        }
    }
    
}
