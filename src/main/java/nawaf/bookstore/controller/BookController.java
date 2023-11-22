package nawaf.bookstore.controller;

import nawaf.bookstore.model.Book;
import nawaf.bookstore.repository.BookRepository;
import nawaf.bookstore.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/{id}") //get book by id
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }
    @GetMapping("/books") //get All Books for testing
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/news") //get All books by release date
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByReleaseDate() {
        return bookRepository.findAll(Sort.by("releaseDate").descending());
    }
    @GetMapping("/books/category/{id}") //get All books by category name
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByCategory(@PathVariable(name = "id") String category) {
        return bookRepository.findAllByCategory(category);
    }

    @PostMapping("/books/add") //post book
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody @Valid Book book){
        bookService.saveBook(book);
    }


    @DeleteMapping("/books/delete") //delete all books
    public String deleteBooks(){
        return bookService.deleteBooks();
    }
    @DeleteMapping("/books/delete/{id}") //delete book by id
    public void deleteBookById(@PathVariable(name = "id") long book){
        bookService.deleteBookById(book);
    }

    @PatchMapping("/books/update/{id}") // update book
    public String updateBookById(@PathVariable(name = "id") long book, @RequestBody Map<String, Object> updates){
        return bookService.updateBookById(book,updates);
    }
}

