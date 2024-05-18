package ch.zhaw.bauersteine.service;

import java.util.Optional;

// import javax.print.attribute.standard.orderState;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.repository.UrneRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UrneRepository urneRepository;

    // public Optional<Order>assigneUrne(String OrderId, String UrneId) {
    //     return Optional.empty();
    // }

    // public Optional<Order> assignUrne(String orderId, String UrneId) {
    //     Optional<Order> orderToAssign = orderRepository.findById(orderId);
    //     if (orderToAssign.isPresent()) {
    //         Order order = orderToAssign.get();
    //         if (order.getOrderState() == orderState.ASSIGNED) {
    //             Urne f = urneRepository.findFirstById(urneId);
    //             if (f != null) {
    //                 order.setOrderState(OrderState.ASSIGNED);
    //                 order.seturneId(f.getId());
    //                 orderRepository.save(order);
    //                 return Optional.of(order);
    //             }
    //         }
    //     }
    //     return Optional.empty();
    // }

    // public Optional<Order> completeorder(String orderId, String urneId) {
    //     Optional<Order> orderToAssign = orderRepository.findById(orderId);
    //     if (orderToAssign.isPresent()) {
    //         Order order = orderToAssign.get();
    //         if (order.getOrderState() == orderState.ASSIGNED) {
    //             Urne f = urneRepository.findFirstById(urneId);
    //             if (f != null) {
    //                 if (order.getUrneId().equals(f.getId())) {
    //                     order.setorderState(OrderState.PAYED);
    //                     orderRepository.save(order);
    //                     return Optional.of(order);
    //                 }
    //             }
    //         }
    //     }
    //     return Optional.empty();
    // }
}
