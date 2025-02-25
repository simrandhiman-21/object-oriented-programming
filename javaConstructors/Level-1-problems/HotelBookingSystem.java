import java.util.Scanner;

public class HotelBookingSystem {

    private String guestName;
    private String roomtype;
    private int nights;


    HotelBookingSystem(){
        this.guestName="unknown";
        this.roomtype="Standard";
        this.nights=1;
    }

    HotelBookingSystem(String guestName,String roomtype,int nights){
        this.guestName=guestName;
        this.roomtype=roomtype;
        this.nights=nights;
    }

    HotelBookingSystem(HotelBookingSystem other){
        this.guestName=other.guestName;
        this.roomtype=other.roomtype;
        this.nights=other.nights;
    }
    // Getter methods
    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomtype;
    }

    public int getNights() {
        return nights;
    }
    public void print(){
        System.out.println("Guest Name -> "+guestName +" Room Type "+roomtype+" Nights "+nights);
    }
    // Setter methods
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setRoomType(String roomType) {
        this.roomtype = roomType;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }


    public void displayBookingInfo() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomtype);
        System.out.println("Nights: " + nights);
    }



    public static void main(String[] args) {
        
        HotelBookingSystem defaultBooking=new HotelBookingSystem();
        defaultBooking.print();

         // Using parameterized constructor
        HotelBookingSystem customBooking=new HotelBookingSystem("John Doe","Deluxe",3);
        customBooking.print();

        // Using copy constructor
        HotelBookingSystem copiedBooking = new HotelBookingSystem(customBooking);
        copiedBooking.displayBookingInfo();
    }
}
