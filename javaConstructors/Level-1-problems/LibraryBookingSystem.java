
    public class LibraryBookingSystem {


            private String title;
            private String author;
            private double price;
            private boolean isAvailable;
        
            LibraryBookingSystem(String title, String author, double price){
                this.title=title;
                this.author=author;
                this.price=price;
                this.isAvailable=true;
                
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

            public boolean isAvailable() {
                return isAvailable;
            }


            public void displayBookInfo() {
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: $" + price);
                System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
            }

            public boolean borrowBook(){
                if(isAvailable){
                    isAvailable=false;
                    System.out.println("The Book "+title+" has been Borrowed");
                    return true;
                }
                else{
                    System.out.println("The Book "+title+" is Not Available");
                    return false;
                }
            }

    public static void main(String[] args) {


        LibraryBookingSystem book1=new LibraryBookingSystem("java","James Gosling",10);
        book1.displayBookInfo();

        book1.borrowBook();
        book1.displayBookInfo();
        
        
    }
}
