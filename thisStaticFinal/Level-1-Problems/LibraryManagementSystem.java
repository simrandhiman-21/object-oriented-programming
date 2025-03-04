
class Book {
    // Static variable shared by all books
        private static String libraryName = "City Central Library";
    
        // Final variable to ensure ISBN cannot be changed
        private final String isbn;
        private String title;
        private String author;
        
        // Constructor using 'this' to resolve ambiguity
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        
        // Static method to display the library name
        public static void displayLibraryName() {
            System.out.println("Library Name: " + libraryName);
        }
        
        // Method to display book details
        public void displayBookDetails() {
            if (this instanceof Book) { // Using instanceof
                System.out.println("Library: " + libraryName);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("ISBN: " + isbn);
            } else {
                System.out.println("Invalid Book Entry.");
            }
        }
        
    public class LibraryManagementSystem {
        public static void main(String[] args) {
            // Display the library name
            Book.displayLibraryName();
            System.out.println();
    
            // Creating book objects
            Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
            Book book2 = new Book("1984", "George Orwell", "978-0451524935");
    
            // Displaying book details
            book1.displayBookDetails();
            System.out.println();
            book2.displayBookDetails();
        }
    }
}
    
