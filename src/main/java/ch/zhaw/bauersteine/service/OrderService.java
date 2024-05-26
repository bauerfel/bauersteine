package ch.zhaw.bauersteine.service;

import java.util.List;
import java.util.Optional;

// import javax.print.attribute.standard.orderState;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.repository.UrneRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UrneRepository urneRepository;

    public Optional<Order> addUrneToOrder(String orderId, String urneId) {
        Optional<Order> orderToAssign = orderRepository.findById(orderId);
        if (orderToAssign.isPresent()) {
            Order order = orderToAssign.get();
            if (order.getState() == OrderState.ASSIGNED) {
                Urne urne = urneRepository.findFirstById(urneId);
                if (urne != null && urne.getState() == UrneState.AVAILABLE) {
                    order.getUrneIds().add(urne.getId());
                    urne.setState(UrneState.ASSIGNED);
                    urneRepository.save(urne);
                    orderRepository.save(order);
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Order> setOrderToPayed(String orderId) {
        Optional<Order> orderToPay = orderRepository.findById(orderId);
        if (orderToPay.isPresent()) {
            Order order = orderToPay.get();
            if (order.getState() == OrderState.ASSIGNED) {
                order.setState(OrderState.PAYED);
                // Setzen des Urnenstatus auf SOLD
                List<String> urneIds = order.getUrneIds();
                for (String urneId : urneIds) {
                    Urne urne = urneRepository.findFirstById(urneId);
                    if (urne != null) {
                        urne.setState(UrneState.SOLD);
                        urneRepository.save(urne);
                    }
                }
                orderRepository.save(order);
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public Optional<Order> setOrderToDelivered(String orderId) {
        Optional<Order> orderToDeliver = orderRepository.findById(orderId);
        if (orderToDeliver.isPresent()) {
            Order order = orderToDeliver.get();
            if (order.getState() == OrderState.PAYED) {
                order.setState(OrderState.DELIVERED);
                orderRepository.save(order);
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    // public Optional<Order> removeUrneFromOrder(String orderId, String urneId) {
    //     Optional<Order> orderToUpdate = orderRepository.findById(orderId);
    //     if (orderToUpdate.isPresent()) {
    //         Order order = orderToUpdate.get();
    //         if (order.getUrneIds().contains(urneId)) {
    //             order.getUrneIds().remove(urneId);
    //             orderRepository.save(order);

    //             Optional<Urne> urneToUpdate = urneRepository.findById(urneId);
    //             if (urneToUpdate.isPresent()) {
    //                 Urne urne = urneToUpdate.get();
    //                 urne.setState(UrneState.AVAILABLE);
    //                 urneRepository.save(urne);
    //             }

    //             return Optional.of(order);
    //         }
    //     }
    //     return Optional.empty();
    // }


    // public boolean deleteOrder(String orderId) {
    //     Optional<Order> orderToDelete = orderRepository.findById(orderId);
    //     if (orderToDelete.isPresent()) {
    //         Order order = orderToDelete.get();
    //         for (String urneId : order.getUrneIds()) {
    //             Optional<Urne> urneToUpdate = urneRepository.findById(urneId);
    //             if (urneToUpdate.isPresent()) {
    //                 Urne urne = urneToUpdate.get();
    //                 urne.setState(UrneState.AVAILABLE);
    //                 urneRepository.save(urne);
    //             }
    //         }
    //         orderRepository.deleteById(orderId);
    //         return true;
    //     }
    //     return false;
    // }
}
