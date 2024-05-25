package ch.zhaw.bauersteine.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.repository.UrneRepository;

class UrneServiceTest {

    @Mock
    private UrneRepository urneRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private UrneService urneService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetUrneToDelivered_UrneNotFound() {
        when(urneRepository.findById("urn123")).thenReturn(Optional.empty());

        Optional<Urne> result = urneService.setUrneToDelivered("urn123");

        assertFalse(result.isPresent());
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testSetUrneToDelivered_UrneNotSold() {
        Urne urne = new Urne();
        urne.setState(UrneState.AVAILABLE);
        when(urneRepository.findById("urn123")).thenReturn(Optional.of(urne));

        Optional<Urne> result = urneService.setUrneToDelivered("urn123");

        assertFalse(result.isPresent());
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testSetUrneToDelivered_UrneSold() {
        Urne urne = new Urne();
        urne.setId("urn123");
        urne.setState(UrneState.SOLD);
        when(urneRepository.findById("urn123")).thenReturn(Optional.of(urne));

        Order order = new Order(Arrays.asList("urn123"), "user@example.com");
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));

        Optional<Urne> result = urneService.setUrneToDelivered("urn123");

        assertTrue(result.isPresent());
        assertEquals(UrneState.DELIVERED, result.get().getState());
        verify(urneRepository).save(any(Urne.class));
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testSetUrneToDelivered_OrderNotDelivered() {
        Urne urne = new Urne();
        urne.setId("urn123");
        urne.setState(UrneState.SOLD);
        when(urneRepository.findById("urn123")).thenReturn(Optional.of(urne));

        Order order = new Order(Arrays.asList("urn123", "urn124"), "user@example.com");
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));

        Urne otherUrne = new Urne();
        otherUrne.setId("urn124");
        otherUrne.setState(UrneState.SOLD);
        when(urneRepository.findById("urn124")).thenReturn(Optional.of(otherUrne));

        Optional<Urne> result = urneService.setUrneToDelivered("urn123");

        assertTrue(result.isPresent());
        assertEquals(UrneState.DELIVERED, result.get().getState());
        verify(urneRepository).save(any(Urne.class));
        verify(orderRepository, never()).save(any(Order.class));
    }
}
