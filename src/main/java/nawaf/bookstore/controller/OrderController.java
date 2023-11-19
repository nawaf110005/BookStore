package nawaf.bookstore.controller;

import nawaf.bookstore.model.Order;
import nawaf.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable(name = "id") Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}
