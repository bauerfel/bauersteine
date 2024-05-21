package ch.zhaw.bauersteine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.model.Urne;

public interface OrderRepository extends MongoRepository<Order, String>{
    List<Order> findByState(double state);
    List<Order> findByUserEmailAndState(String email, OrderState state);
}
