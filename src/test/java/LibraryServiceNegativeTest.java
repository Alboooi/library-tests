import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.fincons.Book;
import it.fincons.LibraryService;

public class LibraryServiceNegativeTest {
        @Test
        void findBookWithNonExistingIdShouldReturnNull() {
            LibraryService libraryService = new LibraryService();

            Book result = libraryService.findBook(99);

            assertNull(result);
        }

        @Test
        void addDuplicateBookShouldThrowException() {
            LibraryService libraryService = new LibraryService();

            Book book1 = new Book(1L, "Dune", "Frank Herbert");
            Book book2 = new Book(1L, "Dune Messiah", "Frank Herbert");

            libraryService.addBook(book1);

            assertThrows(IllegalArgumentException.class, () -> {
                libraryService.addBook(book2);
            });
        }

        @Test
        void removeNonExistingBookShouldReturnFalse() {
            LibraryService libraryService = new LibraryService();

            boolean result = libraryService.removeBook(99L);

            assertFalse(result);
        }
}
