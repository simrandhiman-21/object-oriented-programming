import java.util.Scanner;

class MovieTicket{

    private String movieName;
    private int seatNumber;
    private double price;

    // Constructor to initialize the movie ticket details
    public MovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void bookticket(String movieName,int seatNumber){
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        // Set a fixed price for simplicity; you can modify this logic as needed
        this.price = 10.0; // Example price
        System.out.println("Ticket booked successfully!");
    }

    public void display(){
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);    
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Movie Name ");
        String name=sc.nextLine();

        System.out.println("Enter SeatNumber ");
        int seatNumber=sc.nextInt();

        MovieTicket ticket = new MovieTicket(name, seatNumber, 0); // Initial price is set to 0
        ticket.bookticket(name, seatNumber);
        ticket.display();
        
    }
    
}
