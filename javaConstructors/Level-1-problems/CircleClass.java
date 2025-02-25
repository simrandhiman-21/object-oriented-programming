import java.util.Scanner;

public class CircleClass {
    private double radius;

    CircleClass(){
        // this.radius=2.0;
        this(2.0);
    }
    CircleClass(double radius){
        this.radius=radius;
    }

    // Getter method
    public double getRadius() {
        return radius;
    }

    // Setter method
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        CircleClass defaultCircle=new CircleClass();
        System.out.println("Default Circle Radius: " + defaultCircle.getRadius());
        System.out.println("Default Circle Area: " + defaultCircle.getArea());
        defaultCircle.getArea();

        int radius=sc.nextInt();
        CircleClass customobj=new CircleClass(radius);
        System.out.println("Custom Circle Radius: " + customobj.getRadius());
        System.out.println("Custom Circle Area: " + customobj.getArea());
        customobj.getArea();



    }
    
}
