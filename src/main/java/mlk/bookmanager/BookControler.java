package mlk.bookmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookControler {
    private BookService bookService;

    public BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    @GetMapping
    public List<Book> getAllBooks(@PathVariable Long id) {
        return bookService.getAllBoks();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
      return bookService.getBookById(id).map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }
}
