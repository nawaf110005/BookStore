package nawaf.bookstore.repository;

import nawaf.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
//    List<Book> findAllByReleaseDate();
    List<Book> findAllByCategory(String category);

}
