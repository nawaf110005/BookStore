package nawaf.bookstore.service.impl;

import nawaf.bookstore.DTO.OrderDTO;
import nawaf.bookstore.model.Book;
import nawaf.bookstore.model.OrderB;
import nawaf.bookstore.model.User;
import nawaf.bookstore.repository.BookRepository;
import nawaf.bookstore.repository.OrderRepository;
import nawaf.bookstore.repository.UserRepository;
import nawaf.bookstore.service.interfaces.OrderServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService implements OrderServiceInteface {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderB saveOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId()).get();
        ArrayList<Book> book = new ArrayList<Book>();
        orderDTO.getBookId().forEach((bookId) -> {
            Optional<Book> b = bookRepository.findById(bookId);
                if (b.isPresent()) {
                    book.add(b.get());
                }
        });
        OrderB orderEntity = new OrderB();
//        String OrderCode = UUID.randomUUID().toString().substring(0, 7);
//        orderEntity.setOrderCode(OrderCode);
        orderEntity.setUser(user);
        orderEntity.setBooks(book);
        orderEntity.setPickupAddress(orderDTO.getPickupAddress());
        orderEntity.setPaymentMethod(orderDTO.getPaymentMethod());
        orderEntity.setPickupDate(orderDTO.getPickupDate());
        orderRepository.save(orderEntity);
        return orderEntity;
    }

    @Override
    public List<OrderB> getOrderByUserId(Long userId) {
        return orderRepository.getOrdersByUserId(userId).get();
    }

    @Override
    public void deleteOrderById(long order) {
        OrderB bookFromDB = orderRepository.findById(order).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found "));
         orderRepository.deleteById(order);
    }

    @Override
    public String updateOrderById(long order, Map<String, Object> updates) {
        Optional<OrderB> OrderFound = orderRepository.findById(order);
        if (OrderFound.isPresent()) {
            OrderB existingOrder = OrderFound.get();

            if (updates.containsKey("pickupAddress")) {
                existingOrder.setPickupAddress((String) updates.get("pickupAddress"));
            } else if (updates.containsKey("pickupDate")) {
                existingOrder.setPickupDate((String) updates.get("pickupDate"));
            }
            orderRepository.save(existingOrder);
            return "Order updated";
        } else
        {
            return "Order Not Found";
        }
    }


}

//    public List<OrderB> getOrderByUserId1(Long userId) {
//        User user = userRepository.findById(userId).get();
//
//    }

//    @Override
//    public void saveOrder(OrderDTO order) {
//        if (order.getId() != null) {
//            Optional<OrderB> optionalOrder = orderRepository.findById(order.getId());
//            if (optionalOrder.isPresent())
//                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Order with id " + order.getId() + " already exist");
//        }
//        orderRepository.save(order);
//    }
