import java.util.ArrayList;
import java.util.List;


// Book class (can exist independently)
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (contains multiple Book objects)
class Library { 
    String name;
    List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.display();
        }
        System.out.println();
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        // Creating books (can exist independently)
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("Community Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        
        library2.addBook(book2); // Same book in another library
        library2.addBook(book3);

        // Display books in libraries
        library1.displayBooks();
        library2.displayBooks();
    }
}
