public class Main {
    private static double purchaseBook(Library lib,String isbn, int amount, String userData) {
        try {
             double cost=lib.purchaseBook(isbn, amount, userData);
             System.out.println("Book purchased successfully. Total cost: $" + cost);
             return cost;
        } catch (Exception e) {
            System.out.println("Error purchasing book: " + e.getMessage());
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Library library = new Library();
        
        // Create some books
        Book paperBook1 = new PaperBook("Java Programming", 2020, "1234567890", 29.99, 10);
        Book eBook1 = new EBook("Python Programming", 2021, "0987654321", 19.99,"PDF");
        Book paperBook2 = new PaperBook("C++ Programming", 2019, "1122334455", 39.99, 5);
        Book eBook2 = new EBook("JavaScript Programming", 2022, "5566778899", 24.99,"EPUB");
        Book showcaseBook1 = new ShowcaseBook("Data Structures", 2018, "1231231234", 49.99, "Hardcover");
        Book showcaseBook2 = new ShowcaseBook("Algorithms", 2017, "4321432143", 59.99, "Paperback");
        // Add books to the library
        library.addBook(paperBook1);
        library.addBook(eBook1);
        library.addBook(paperBook2);
        library.addBook(eBook2);
        library.addBook(showcaseBook1);
        library.addBook(showcaseBook2);
        // Check availability
        System.out.println("Is Java Programming available? " + library.isBookAvailable("1234567890"));
        
        // Try to purchase a book from each type
        purchaseBook(library,"1234567890", 2, "123 Main St, City, Country");
        purchaseBook(library,"0987654321", 1, "abdallahsafan05@gmail.com");
        purchaseBook(library,"1231231234", 1, "Showcase Address, City, Country");

        // Try to purchase a book that is not available
        purchaseBook(library,"9999999999", 1, "789 Oak St, City, Country");

        // Try to purchase a book with insufficient stock
        purchaseBook(library,"1234567890", 20, "123 Main St, City, Country");

    }
}
