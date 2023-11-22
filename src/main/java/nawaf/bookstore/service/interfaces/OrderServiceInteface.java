package nawaf.bookstore.service.interfaces;

import nawaf.bookstore.DTO.OrderDTO;
import nawaf.bookstore.model.OrderB;

import java.util.List;
import java.util.Map;

public interface OrderServiceInteface {
    OrderB saveOrder(OrderDTO orderDTO);

    List<OrderB> getOrderByUserId(Long userId);

    void deleteOrderById(long order);

    String updateOrderById(long order, Map<String, Object> updates);

//    void addOrder(OrderDTO orderDTO);
}
