package ch.zhaw.bauersteine.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.service.OrderService;
import ch.zhaw.bauersteine.service.UrneService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UrneService urneService;

    @PostMapping("/{orderId}/addUrne/{urneId}")
    public ResponseEntity<Order> addUrneToOrder(@PathVariable String orderId, @PathVariable String urneId) {
        Optional<Order> updatedOrder = orderService.addUrneToOrder(orderId, urneId);
        return updatedOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/pay")
    public ResponseEntity<Order> setOrderToPayed(@PathVariable String orderId) {
        Optional<Order> updatedOrder = orderService.setOrderToPayed(orderId);
        return updatedOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/deliverOrder")
    public ResponseEntity<Order> setOrderToDelivered(@PathVariable String orderId) {
        Optional<Order> updatedOrder = orderService.setOrderToDelivered(orderId);
        return updatedOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{urneId}/deliverUrne")
    public ResponseEntity<Urne> setUrneToDelivered(@PathVariable String urneId) {
        Optional<Urne> updatedUrne = urneService.setUrneToDelivered(urneId);
        return updatedUrne.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
