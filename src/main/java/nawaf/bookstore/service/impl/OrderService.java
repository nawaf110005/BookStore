package nawaf.bookstore.service.impl;

import nawaf.bookstore.model.OrderB;
import nawaf.bookstore.repository.OrderRepository;
import nawaf.bookstore.service.interfaces.OrderServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderService implements OrderServiceInteface {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void saveOrder(OrderB order) {
        if (order.getId() != null) {
            Optional<OrderB> optionalOrder = orderRepository.findById(order.getId());
            if (optionalOrder.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Order with id " + order.getId() + " already exist");
        }
        orderRepository.save(order);
    }
}