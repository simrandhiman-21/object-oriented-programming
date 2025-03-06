import java.util.*;
// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private List<String> records;
    
    public InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.records = new ArrayList<>();
    }
    
    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}

// OutPatient class
class OutPatient extends Patient {
    private double consultationFee;
    
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient patient1 = new InPatient("P001", "John Doe", 45, 2000, 5);
        OutPatient patient2 = new OutPatient("P002", "Jane Smith", 30, 500);
        
        patients.add(patient1);
        patients.add(patient2);
        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).addRecord("Routine Check-up");
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println("--------------------------");
        }
    }
}