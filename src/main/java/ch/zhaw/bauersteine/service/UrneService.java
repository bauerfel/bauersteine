package ch.zhaw.bauersteine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.repository.UrneRepository;
@Service
public class UrneService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UrneRepository urneRepository;

     public Optional<Urne> setUrneToDelivered(String urneId) {
        Optional<Urne> urneToDeliver = urneRepository.findById(urneId);
        if (urneToDeliver.isPresent()) {
            Urne urne = urneToDeliver.get();
            if (urne.getState() == UrneState.SOLD) {
                urne.setState(UrneState.DELIVERED);
                urneRepository.save(urne);

                // Überprüfen, ob die Bestellung mit dieser Urne auch den Status DELIVERED setzen soll
                orderRepository.findAll().forEach(order -> {
                    if (order.getUrneIds().contains(urneId)) {
                        boolean allUrnesDelivered = order.getUrneIds().stream()
                            .allMatch(id -> {
                                Urne u = urneRepository.findById(id).orElse(null);
                                return u != null && u.getState() == UrneState.DELIVERED;
                            });

                        if (allUrnesDelivered) {
                            order.setState(OrderState.DELIVERED);
                            orderRepository.save(order);
                        }
                    }
                });

                return Optional.of(urne);
            }
        }
        return Optional.empty();
    }
}


