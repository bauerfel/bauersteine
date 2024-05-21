package ch.zhaw.bauersteine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.bauersteine.model.OrderCreateDTO;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(
            @RequestBody OrderCreateDTO cDTO,
            @AuthenticationPrincipal Jwt jwt) {
        
        if (jwt == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String userEmail = jwt.getClaimAsString("email");
        Order oDAO = new Order(cDTO.getUrneIds(), userEmail);
        Order o = orderRepository.save(oDAO);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrder(
            @RequestParam(required = false) Double is) {
        List<Order> allO;
        if (is != null) {
            allO = orderRepository.findByState(is);
            return new ResponseEntity<>(allO, HttpStatus.OK);
        } else {
            allO = orderRepository.findAll();
            return new ResponseEntity<>(allO, HttpStatus.OK);
        }
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Optional<Order> optOrder = orderRepository.findById(id);
        // Falls die ID existiert, OK und die Urne zurückgeben
        return optOrder.stream().filter(x -> x.getId().equals(id)).findFirst().map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        // Falls die ID nicht existiert, NOT_FOUND zurückgeben
    }

    @GetMapping("/order/byEmailAndStatus")
    public ResponseEntity<List<Order>> getOrdersByEmailAndStatus(
            @RequestParam String email, @RequestParam OrderState status) {
        List<Order> orders = orderRepository.findByUserEmailAndState(email, status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
