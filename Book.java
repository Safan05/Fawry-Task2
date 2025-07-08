// to use for any new added book
interface bookinterface {
    String getTitle();
    String getISBN();
    double getPrice();
    int getYearPublished();
    boolean isAvailable();
}
// To use if new type of Shipable book is added
interface Shipable {
    double ShipBook(String address,int Quantity);
}
// to use if new type of Mailable book is added
interface Mailable {
    double MailBook(String email,int Quantity);
}
// Base class for all book types
abstract class Book implements bookinterface {
    private String title;
    private int yearPublished;
    private String isbn;
    private double price;
    Book(String title, int yearPublished, String isbn, double price) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.price = price;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getISBN() {
        return isbn;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public int getYearPublished() {
        return yearPublished;
    }
    @Override
    public abstract boolean isAvailable();
}
class PaperBook extends Book implements Shipable {
    private int stock;
    PaperBook(String title, int yearPublished, String isbn, double price, int stock) {
        super(title, yearPublished, isbn, price);
        this.stock = stock;
    }
    @Override
    public boolean isAvailable() {
        return stock > 0;
    }
    public int getStock() {
        return stock;
    }
    public void incrementStock(int amount) {
        if (amount > 0) {
            stock += amount;
        }
    }
    public void decrementStock(int amount) {
        if (amount > 0 && stock >= amount) {
            stock -= amount;
        }
        else {
            throw new RuntimeException("Insufficient stock.");
        }
    }
    @Override
    public double ShipBook(String address,int Quantity) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
            decrementStock(Quantity);
            System.out.println("Shipped book "+this.getTitle()+" with quantity "+ Quantity+ " to: " + address);
            return this.getPrice()*Quantity;
        } 
}
class EBook extends Book implements Mailable {
    private String fileType;
    EBook(String title, int yearPublished, String isbn, double price, String fileType) {
        super(title, yearPublished, isbn, price);
        this.fileType = fileType;
    }
    @Override
    public boolean isAvailable() {
        return true; 
    }
    public String getFileType() {
        return fileType;
    }
    @Override
    public double MailBook(String email,int Quantity) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        System.out.println("EBook "+this.getTitle()+" with type "+this.getFileType()+" sent to: " + email+ " with quantity "+ Quantity);
        return this.getPrice()*Quantity;
    }
}
class ShowcaseBook extends Book {
    ShowcaseBook(String title, int yearPublished, String isbn, double price, String author) {
        super(title, yearPublished, isbn, price);
    }
    @Override
    public boolean isAvailable() {
        return false; 
    }
}