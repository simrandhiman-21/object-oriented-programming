import java.util.ArrayList;
import java.util.List;

// Patient class (Association - Patients can consult multiple doctors)
class Patient {
    String name;
    List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this); // Ensure bidirectional association
        }
    }

    public void displayDoctors() {
        System.out.println("Patient: " + name + " is consulting:");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor: " + doctor.name);
        }
    }
}

// Doctor class (Association - Doctors can consult multiple patients)
class Doctor {
    String name;
    List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is consulting Patient " + patient.name);
    }

    public void displayPatients() {
        System.out.println("Doctor: " + name + " is consulting:");
        for (Patient patient : patients) {
            System.out.println("Patient: " + patient.name);
        }
    }
}

// Hospital class (Aggregates Doctors and Patients, but they exist independently)
class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void display() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("Doctor: " + doc.name);
        }
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println("Patient: " + pat.name);
        }
    }
}

public class HospitalDocPatient {
    public static void main(String[] args) {
        // Creating hospital
        Hospital hospital = new Hospital("City Hospital");

        // Creating doctors
        Doctor doc1 = new Doctor("Dr. Smith");
        Doctor doc2 = new Doctor("Dr. Johnson");
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);

        // Creating patients
        Patient pat1 = new Patient("Alice");
        Patient pat2 = new Patient("Bob");
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);

        // Establishing doctor-patient consultations (Many-to-Many Association)
        pat1.addDoctor(doc1);
        pat1.addDoctor(doc2);
        pat2.addDoctor(doc1);

        // Simulating consultations
        doc1.consult(pat1);
        doc2.consult(pat1);
        doc1.consult(pat2);

        // Display hospital structure
        hospital.display();
        pat1.displayDoctors();
        pat2.displayDoctors();
        doc1.displayPatients();
        doc2.displayPatients();
    }
}
