import java.util.Scanner;

public class HandBook {

    String title;
    String author;
    double price;

    HandBook(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void display(){
        System.out.println("Title : "+title+" author : "+author+"price : "+price);
    }

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Title ");
        String title=sc.nextLine();

        System.out.println("Enter Author Name ");
        String author=sc.nextLine();

        System.out.println("Enter Price ");
        double price=sc.nextDouble();

        HandBook obj = new HandBook(title,author,price);
        
        obj.display();        
    }    
}
