package nawaf.bookstore.controller;

import nawaf.bookstore.model.OrderB;
import nawaf.bookstore.repository.OrderRepository;
import nawaf.bookstore.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderB getOrderById(@PathVariable(name = "id") Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @PostMapping("/orders/add")
    public void addProject(@RequestBody @Valid OrderB order){
        orderService.saveOrder(order);
    }
}
