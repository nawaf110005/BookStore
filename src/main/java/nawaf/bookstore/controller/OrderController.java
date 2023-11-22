package nawaf.bookstore.controller;

import nawaf.bookstore.DTO.OrderDTO;
import nawaf.bookstore.model.Book;
import nawaf.bookstore.model.OrderB;
import nawaf.bookstore.repository.OrderRepository;
import nawaf.bookstore.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/ordersById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderB> getOrderByUserId(@PathVariable(name = "id") Long userId) {
        return orderService.getOrderByUserId(userId);
    }

//    @GetMapping("/ordersById/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<OrderB> getOrderByUserId1(@PathVariable(name = "id") Long userId) {
//        return orderService.getOrderByUserId1(userId);
//    }

    @GetMapping("/orders") //get All Orders for testing
    @ResponseStatus(HttpStatus.OK)
    public List<OrderB> getAllOrders() {
        return orderRepository.findAll();
    }

//    @PostMapping("/orders/add")
//    public void addOrder(@RequestBody @Valid OrderB order){
//        orderService.saveOrder(order);
//    }
@PostMapping("/orders/add")
    public OrderB saveOrder(@RequestBody OrderDTO orderDTO) {
        try {
            OrderB res = orderService.saveOrder(orderDTO);
            String massage = "Order add successfully ";
            return res;
        } catch (Exception e) {
            String errorMassage = "Order Error: " + e.getMessage();
            return null;
        }
    }
    @DeleteMapping("/orders/delete/{id}") //delete book by id
    public void deleteOrderById(@PathVariable(name = "id") long order){
         orderService.deleteOrderById(order);
    }

    @PatchMapping("/orders/update/{id}") // update book
    public String updateBookById(@PathVariable(name = "id") long order, @RequestBody Map<String, Object> updates){
        return orderService.updateOrderById(order,updates);
    }
}
