# Quantum Bookstore 

## Design illustration

### Abstract Class: `Book`
The `Book` class serves as the base class for all book types. It defines common attributes such as `title`, `yearPublished`, `isbn`, and `price`. It also declares an abstract method `isAvailable()` to be implemented by subclasses.

#### Subclasses:
- **`PaperBook`**:
  - Adds a `stock` attribute to manage inventory.
  - Implements the `Shipable` interface to handle shipping.
- **`EBook`**:
  - Adds a `fileType` attribute to specify the format (e.g., PDF, EPUB).
  - Implements the `Mailable` interface to handle emailing.
- **`ShowcaseBook`**:
  - Represents books that are not available for purchase.

### Factory Pattern in `Library`
The `Library` class uses a factory pattern to handle book purchases. Based on the type of book, it delegates the purchase process to the appropriate method:
- `ShipBook` for `PaperBook`
- `MailBook` for `EBook`

This design ensures scalability, allowing new book types to be added with minimal changes.

### Error Handling
The system uses `try-catch` blocks to handle various errors:
- **RuntimeException**:
  - Thrown when a book is not found or has insufficient stock.
- **IllegalArgumentException**:
  - Thrown for unsupported book types or empty address or mail.

### Usage of Polymorphism
Polymorphism is achieved through the `Book` abstract class and its subclasses. The `Library` class interacts with `Book` objects without knowing their specific types, enabling flexible and reusable code.
