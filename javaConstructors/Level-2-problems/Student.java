public class Student {

    public int rollNumber;
    protected String name;
    private Double CGPA;
    
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA(){
        return CGPA;
    }

    public void setCGPA(double CGPA){
        if(CGPA>=0.0 && CGPA<=10.0){
            this.CGPA = CGPA;
        }
        else{
            System.out.println("CGPA should be between 0.0 and 10.0");
        }
    }
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student{
    private String researchTopic;


    public PostgraduateStudent(int rollNumber,String name,double CGPA,String researchTopic){
        super(rollNumber,name,CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name); // Accessing protected member from parent class
        System.out.println("CGPA: " + getCGPA()); // Accessing private CGPA via public getter
        System.out.println("Research Topic: " + researchTopic);
    }

    public static void main(String[] args) {

        Student student1 = new Student(101, "Alexa", 8.5);
        student1.displayStudentDetails();
        

        student1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        PostgraduateStudent pgstudent=new PostgraduateStudent(001,"Siri",9.2,"ML");
        pgstudent.displayStudentDetails();   
        
    }
}
