package nawaf.bookstore.repository;

import nawaf.bookstore.model.OrderB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  extends JpaRepository<OrderB,Long> {
    @Query("SELECT o FROM OrderB o WHERE o.user.id = :userId")
    Optional<List<OrderB>> getOrdersByUserId(Long userId);
    List<OrderB> findByUser_Id(Long userId);

    List<OrderB> deleteOrderById(Long userId);
}
