package nawaf.bookstore.service.interfaces;

import nawaf.bookstore.model.Book;

import java.util.Map;

public interface BookServiceInterface {
    void saveBook(Book book);

    String deleteBooks();

    void deleteBookById(long id);

    String updateBookById(long id, Map<String, Object> updates);
}
