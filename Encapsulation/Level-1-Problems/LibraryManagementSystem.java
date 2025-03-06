import java.util.*;
// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public abstract int getLoanDuration();
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;
    
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }
    
    @Override
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Book reserved: " + getTitle());
        } else {
            System.out.println("Book is already reserved.");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;
    
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    
    @Override
    public int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }
    
    @Override
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("DVD reserved: " + getTitle());
        } else {
            System.out.println("DVD is already reserved.");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        Book item1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine item2 = new Magazine("M002", "National Geographic", "Various");
        DVD item3 = new DVD("D003", "Inception", "Christopher Nolan");
        
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
                ((Reservable) item).reserveItem();
                System.out.println("Availability after reservation: " + ((Reservable) item).checkAvailability());
            }
            System.out.println("--------------------------");
        }
    }
}