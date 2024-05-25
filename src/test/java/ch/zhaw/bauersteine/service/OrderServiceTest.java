package ch.zhaw.bauersteine.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import ch.zhaw.bauersteine.repository.UrneRepository;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UrneRepository urneRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUrneToOrder_OrderNotFound() {
        when(orderRepository.findById("order123")).thenReturn(Optional.empty());

        Optional<Order> result = orderService.addUrneToOrder("order123", "urne123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testAddUrneToOrder_OrderNotAssigned() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.DELIVERED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.addUrneToOrder("order123", "urne123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testAddUrneToOrder_UrneNotFound() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));
        when(urneRepository.findFirstById("urne123")).thenReturn(null);

        Optional<Order> result = orderService.addUrneToOrder("order123", "urne123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testAddUrneToOrder_UrneNotAvailable() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Urne urne = new Urne();
        urne.setState(UrneState.ASSIGNED);
        when(urneRepository.findFirstById("urne123")).thenReturn(urne);

        Optional<Order> result = orderService.addUrneToOrder("order123", "urne123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testAddUrneToOrder_Success() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Urne urne = new Urne();
        urne.setId("urne123");
        urne.setState(UrneState.AVAILABLE);
        when(urneRepository.findFirstById("urne123")).thenReturn(urne);

        Optional<Order> result = orderService.addUrneToOrder("order123", "urne123");

        assertTrue(result.isPresent());
        assertTrue(result.get().getUrneIds().contains("urne123"));
        assertEquals(UrneState.ASSIGNED, urne.getState());
        verify(orderRepository).save(any(Order.class));
        verify(urneRepository).save(any(Urne.class));
    }

    // Payed
    @Test
    void testSetOrderToPayed_OrderNotFound() {
        when(orderRepository.findById("order123")).thenReturn(Optional.empty());

        Optional<Order> result = orderService.setOrderToPayed("order123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testSetOrderToPayed_OrderNotAssigned() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.DELIVERED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.setOrderToPayed("order123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
        verify(urneRepository, never()).save(any(Urne.class));
    }

    @Test
    void testSetOrderToPayed_Success() {
        Order order = new Order(new ArrayList<>(Arrays.asList("urne123", "urne124")), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Urne urne1 = new Urne();
        urne1.setId("urne123");
        urne1.setState(UrneState.ASSIGNED);
        Urne urne2 = new Urne();
        urne2.setId("urne124");
        urne2.setState(UrneState.ASSIGNED);

        when(urneRepository.findFirstById("urne123")).thenReturn(urne1);
        when(urneRepository.findFirstById("urne124")).thenReturn(urne2);

        Optional<Order> result = orderService.setOrderToPayed("order123");

        assertTrue(result.isPresent());
        assertEquals(OrderState.PAYED, result.get().getState());
        assertEquals(UrneState.SOLD, urne1.getState());
        assertEquals(UrneState.SOLD, urne2.getState());
        verify(orderRepository).save(any(Order.class));
        verify(urneRepository, times(2)).save(any(Urne.class));
    }

    @Test
    void testSetOrderToPayed_UrneNotFound() {
        Order order = new Order(new ArrayList<>(Arrays.asList("urne123", "urne124")), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Urne urne1 = new Urne();
        urne1.setId("urne123");
        urne1.setState(UrneState.ASSIGNED);

        when(urneRepository.findFirstById("urne123")).thenReturn(urne1);
        when(urneRepository.findFirstById("urne124")).thenReturn(null);

        Optional<Order> result = orderService.setOrderToPayed("order123");

        assertTrue(result.isPresent());
        assertEquals(OrderState.PAYED, result.get().getState());
        assertEquals(UrneState.SOLD, urne1.getState());
        verify(orderRepository).save(any(Order.class));
        verify(urneRepository).save(urne1);
        verify(urneRepository, never()).save(argThat(urne -> urne != null && urne.getId().equals("urne124")));
    }

    // Delivered
    @Test
    void testSetOrderToDelivered_OrderNotFound() {
        when(orderRepository.findById("order123")).thenReturn(Optional.empty());

        Optional<Order> result = orderService.setOrderToDelivered("order123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void testSetOrderToDelivered_OrderNotPayed() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.ASSIGNED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.setOrderToDelivered("order123");

        assertFalse(result.isPresent());
        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void testSetOrderToDelivered_Success() {
        Order order = new Order(new ArrayList<>(), "user@example.com");
        order.setState(OrderState.PAYED);
        when(orderRepository.findById("order123")).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.setOrderToDelivered("order123");

        assertTrue(result.isPresent());
        assertEquals(OrderState.DELIVERED, result.get().getState());
        verify(orderRepository).save(any(Order.class));
    }
}
