class Book {
    public String ISBN;
    protected String title;
    private String author;

    
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    
    public String getAuthor() {
        return author;
    }

   
    public void setAuthor(String author) {
        this.author = author;
    }

    
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;

  
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    
    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN); // Accessing public member from parent class
        System.out.println("Title: " + title); // Accessing protected member from parent class
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
       
        Book book1 = new Book("1234567890", "Java Programming", "John Doe");
        book1.displayBookDetails();
        System.out.println();

       
        book1.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book1.getAuthor());
        System.out.println();

       
        EBook ebook1 = new EBook("987654321", "Python Basics", "Alice Smith", 5.2);
        ebook1.displayEBookDetails();
    }
}
