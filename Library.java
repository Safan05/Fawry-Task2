import java.util.Map;
import java.util.Calendar;
import java.util.HashMap;
public class Library {
    private Map<String,Book> books;
    public Library() {
        books = new HashMap<>();
    }
    public void addBook(Book b) {
        if (b != null && b.getISBN() != null) {
            books.put(b.getISBN(), b);
        }
    }
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    public void removeBook(String isbn) {
        books.remove(isbn);
    }
    public boolean isBookAvailable(String isbn) {
        Book b = books.get(isbn);
        return b != null && b.isAvailable();
    }
    public void incrementStock(String isbn, int amount) {
        Book b = books.get(isbn);
        if (b instanceof PaperBook && amount > 0) {
            ((PaperBook) b).incrementStock(amount);
        }
    }
    public void decrementStock(String isbn, int amount) {
        Book b = books.get(isbn);
        if (b instanceof PaperBook && amount > 0) {
            ((PaperBook) b).decrementStock(amount);
        }
    }
    public Map<String, Book> getAllBooks() {
        return new HashMap<>(books);
    }
    public int getTotalBooks() {
        return books.size();
    }
    public void clearInventory() {
        books.clear();
    }
    public void removeOutdatedBooks(int Numberofyears) {
        int year=Calendar.getInstance().get(Calendar.YEAR);
        books.values().removeIf(b -> b.getYearPublished() < year- Numberofyears);
    }
    
    public double purchaseBook(String isbn, int amount,String userdata){
        Book b = books.get(isbn);
        if(b == null) {
            throw new RuntimeException("Book not found in the library.");
        }
        if (b instanceof PaperBook && amount > 0) {
            PaperBook paperBook = (PaperBook) b;
            return paperBook.ShipBook(userdata, amount);
        } else if (b instanceof EBook) {
            EBook eBook = (EBook) b;
            return eBook.MailBook(userdata, amount);
        } else {
           throw new IllegalArgumentException("Unsupported book type for purchase.");
        }
    }
}
