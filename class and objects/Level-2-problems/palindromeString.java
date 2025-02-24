import java.util.Scanner;

class palindromeChecker{
    String input;

    palindromeChecker(String input){
        this.input=input;
    }
    public boolean check(){

        String original=input;
        StringBuilder sb=new StringBuilder(input);
        sb.reverse();

        return original.equals(sb.toString());

    }
    public void display(){
        if (check()) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}
public class palindromeString {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String ");
        String input=sc.nextLine();
        
        palindromeChecker obj=new palindromeChecker(input);
        obj.display();
    }    
}
