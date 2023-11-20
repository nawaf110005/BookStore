package nawaf.bookstore.repository;

import nawaf.bookstore.model.OrderB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderB,Long> {
}
