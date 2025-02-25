
public class BookClass {
    private String title;
    private String author;
    private double price;

    BookClass(){
        title="Unknown";
        author="Unknown";
        price=0.0;
    }

    BookClass( String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
     // Setter methods
     public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        BookClass defaultBook=new BookClass();
        defaultBook.print();
        BookClass customBook=new BookClass("pythonlearning","python",300);
        customBook.print();
        
    }
    
}
