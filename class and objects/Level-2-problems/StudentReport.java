import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit;

class Student{
    String name;
    int rollno;
    double marks;

    Student(String name,
    int rollno,
    double marks){
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;

    }
    public String calculateGrade() {
        if (marks >= 90) {
            return "O"; // Outstanding
        } else if (marks >= 80) {
            return "A+";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 55) {
            return "C";
        } else {
            return "F"; // Fail
        }
    }

    public void displaydetails(){
        System.out.println("Name : "+name+" Rol lno : "+rollno+ " Marks : "+marks+" Grades "+calculateGrade());
    }
}


public class StudentReport {
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    ArrayList<Student> list=new ArrayList<>();

         while(true){

                System.out.println("Enter Name ");
                String name=sc.nextLine();

                if(name.equalsIgnoreCase("exit")){
                    break;
                }

                
                System.out.println("Enter RollNo ");
                int rollno=sc.nextInt();
                
                System.out.println("Enter Marks");
                double marks=sc.nextDouble();
                sc.nextLine();

            list.add(new Student(name,rollno,marks));
        
        }

        for(Student stduent:list){
            stduent.displaydetails();
        }
    }
}
