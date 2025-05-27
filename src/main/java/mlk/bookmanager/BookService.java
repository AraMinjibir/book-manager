package mlk.bookmanager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService(List<Book> books) {
        this.books = books;
    }

    public Book addBook(Book book){
        books.add(book);

        return book;
    }
    public boolean deleteBook(Long id){
        return books.removeIf(book -> book.getId().equals(id));
    }

    public Optional<Book> getBookById(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
    public List<Book>  getAllBoks(){
        return books;
    }
}
