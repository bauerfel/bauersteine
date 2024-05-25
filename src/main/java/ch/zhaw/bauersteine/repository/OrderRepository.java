package ch.zhaw.bauersteine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderState;

public interface OrderRepository extends MongoRepository<Order, String>{
    List<Order> findByState(OrderState state);
    List<Order> findByUserEmailAndState(String email, OrderState state);
}
