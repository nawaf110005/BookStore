package nawaf.bookstore.service.impl;

import nawaf.bookstore.model.Book;
import nawaf.bookstore.repository.BookRepository;
import nawaf.bookstore.service.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void saveBook(Book book) {
        if (book.getId() != null) {
            Optional<Book> optionalBook = bookRepository.findById(book.getId());
            if (optionalBook.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "book with id " + book.getId() + " already exist");
        }
        bookRepository.save(book);
    }

    @Override
    public String deleteBooks() {
        bookRepository.deleteAll();
        return "All books deleted";
    }

    @Override
    public void deleteBookById(long id) {//delet book by id
        Book bookFromDB = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        bookRepository.deleteById(id);
    }

    @Override
    public String updateBookById(long id, Map<String, Object> updates) {
        Optional<Book> BookFound = bookRepository.findById(id);
        if (BookFound.isPresent()) {
            Book existingBook = BookFound.get();

            if (updates.containsKey("id")) {
                existingBook.setId((Long) updates.get("id"));
            } else if (updates.containsKey("title")) {
                existingBook.setTitle((String) updates.get("title"));
            } else if (updates.containsKey("category")) {
                existingBook.setCategory((String) updates.get("category"));
            }else if (updates.containsKey("img")) {
                existingBook.setImg((String) updates.get("img"));
            } else if (updates.containsKey("author")) {
                existingBook.setAuthor((String) updates.get("author"));
            }else if (updates.containsKey("price")) {
                existingBook.setPrice((Double) updates.get("price"));
            }else if (updates.containsKey("releaseDate")) {
                existingBook.setReleaseDate((LocalDate) updates.get("releaseDate"));
            }

            bookRepository.save(existingBook);
            return "Book updated";
        } else
        {
            return "Book Not Found";
        }
    }


}
