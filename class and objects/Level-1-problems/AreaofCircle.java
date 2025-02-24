import java.util.Scanner;

public class AreaofCircle {

    final double PI=3.14;
    double radius;

    AreaofCircle(double radius){
        this.radius=radius;
    }

    
    public double Area(){
        return 2*PI*radius*radius;
    }
    public void displayArea(){
        System.out.println("Circle Area is :"+Area());
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Radius of circle ");
        double r=sc.nextDouble();

        AreaofCircle obj1=new AreaofCircle(r);
        obj1.displayArea();
        
    }
    
}
