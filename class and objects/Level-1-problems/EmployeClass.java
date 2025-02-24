import java.util.ArrayList;
import java.util.Scanner;

public class EmployeClass {

    String name;
    int id;
    double salary;

    EmployeClass(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }


    public void displayDetails(){
            System.out.println("Name is = "+ name+" Id is : "+id +" salary is -> "+salary);
    }
    
     public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        ArrayList<EmployeClass> list=new ArrayList<>();

        while(true){
            System.out.println("Enter name of employe ");
            String name=sc.nextLine();

            if(name.equalsIgnoreCase("exist")){
                break;
            }

            System.out.println("Enter id ");
            int id=sc.nextInt();

            System.out.println("Enter salary ");
            double salary=sc.nextDouble();
            sc.nextLine();

            list.add(new EmployeClass(name,id,salary));

        }


        for(EmployeClass employe:list){
            employe.displayDetails();
        }

     }
}