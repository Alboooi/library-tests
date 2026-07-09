import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import it.fincons.Book;
import it.fincons.LibraryService;

public class LibraryServiceNegativeTest {
        @Test
        void findBookWithNonExistingId() {
            LibraryService libraryService = new LibraryService();

            Object result = libraryService.findBook(99L);

            assertNull(result);
        }

        @Test
        void duplicateBooks() {
            LibraryService libraryService = new LibraryService();

            libraryService.addBook(new Book(1L, "Dune", "Frank Herbert"));
            libraryService.addBook(new Book(1L, "Dune Messiah", "Frank Herbert"));

            libraryService.removeBook(1L);

            assertNull(libraryService.findBook(1L));
        }

        @Test
        void removeNonExistingBook() {
            LibraryService libraryService = new LibraryService();

            assertDoesNotThrow(() -> libraryService.removeBook(99L));
        }
    }


