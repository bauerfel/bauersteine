package ch.zhaw.bauersteine.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import ch.zhaw.bauersteine.model.Order;
import ch.zhaw.bauersteine.model.OrderCreateDTO;
import ch.zhaw.bauersteine.model.OrderState;
import ch.zhaw.bauersteine.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @Mock
    private Jwt jwt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser
    void testCreateOrder() throws Exception {
        OrderCreateDTO orderCreateDTO = new OrderCreateDTO(Arrays.asList("urne1", "urne2"));
        Order order = new Order(Arrays.asList("urne1", "urne2"), "user@example.com");
        order.setId("123");

        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(jwt.getClaimAsString("email")).thenReturn("user@example.com");

        mockMvc.perform(post("/api/order")
                .with(SecurityMockMvcRequestPostProcessors.jwt().jwt(jwt))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(orderCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.urneIds[0]").value("urne1"))
                .andExpect(jsonPath("$.urneIds[1]").value("urne2"))
                .andExpect(jsonPath("$.userEmail").value("user@example.com"))
                .andExpect(jsonPath("$.state").value("ASSIGNED"));
    }

    @Test
    void testCreateOrderUnauthorized() throws Exception {
        OrderCreateDTO orderCreateDTO = new OrderCreateDTO(Arrays.asList("urne1", "urne2"));

        mockMvc.perform(post("/api/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(orderCreateDTO)))
                .andExpect(status().isForbidden());
    }

    // getallorder
    @Test
    @WithMockUser
    void testGetAllOrder() throws Exception {
        Order order1 = new Order(Arrays.asList("urne1", "urne2"), "user1@example.com");
        order1.setId("1");
        Order order2 = new Order(Arrays.asList("urne3", "urne4"), "user2@example.com");
        order2.setId("2");
        List<Order> orderList = Arrays.asList(order1, order2);

        when(orderRepository.findAll()).thenReturn(orderList);

        mockMvc.perform(get("/api/order")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].urneIds[0]").value("urne1"))
                .andExpect(jsonPath("$[0].urneIds[1]").value("urne2"))
                .andExpect(jsonPath("$[0].userEmail").value("user1@example.com"))
                .andExpect(jsonPath("$[0].state").value("ASSIGNED"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].urneIds[0]").value("urne3"))
                .andExpect(jsonPath("$[1].urneIds[1]").value("urne4"))
                .andExpect(jsonPath("$[1].userEmail").value("user2@example.com"))
                .andExpect(jsonPath("$[1].state").value("ASSIGNED"));
    }

    @Test
    @WithMockUser
    void testGetAllOrderByState() throws Exception {
        Order order1 = new Order(Arrays.asList("urne1", "urne2"), "user1@example.com");
        order1.setId("1");
        order1.setState(OrderState.ASSIGNED);
        List<Order> orderList = Collections.singletonList(order1);

        when(orderRepository.findByState(OrderState.ASSIGNED)).thenReturn(orderList);

        mockMvc.perform(get("/api/order")
                .param("state", "ASSIGNED")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].urneIds[0]").value("urne1"))
                .andExpect(jsonPath("$[0].urneIds[1]").value("urne2"))
                .andExpect(jsonPath("$[0].userEmail").value("user1@example.com"))
                .andExpect(jsonPath("$[0].state").value("ASSIGNED"));
    }

    // getorderwithid
    @Test
    @WithMockUser
    void testGetOrderById() throws Exception {
        Order order = new Order(Arrays.asList("urne1", "urne2"), "user@example.com");
        order.setId("123");

        when(orderRepository.findById("123")).thenReturn(Optional.of(order));

        mockMvc.perform(get("/api/order/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.urneIds[0]").value("urne1"))
                .andExpect(jsonPath("$.urneIds[1]").value("urne2"))
                .andExpect(jsonPath("$.userEmail").value("user@example.com"))
                .andExpect(jsonPath("$.state").value("ASSIGNED"));
    }

    @Test
    @WithMockUser
    void testGetOrderByIdNotFound() throws Exception {
        when(orderRepository.findById("123")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/order/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // emailandState
    @Test
    @WithMockUser
    void testGetOrderByUserEmailAndState() throws Exception {
        Order order1 = new Order(Arrays.asList("urne1", "urne2"), "user@example.com");
        order1.setId("1");
        order1.setState(OrderState.ASSIGNED);
        List<Order> orderList = Collections.singletonList(order1);
    
        when(orderRepository.findByUserEmailAndState("user@example.com", OrderState.ASSIGNED)).thenReturn(orderList);
        when(jwt.getClaimAsString("email")).thenReturn("user@example.com");
    
        mockMvc.perform(get("/api/order/byEmailAndStatus")
                .param("email", "user@example.com")
                .param("status", "ASSIGNED")
                .with(SecurityMockMvcRequestPostProcessors.jwt().jwt(jwt))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].urneIds[0]").value("urne1"))
                .andExpect(jsonPath("$[0].urneIds[1]").value("urne2"))
                .andExpect(jsonPath("$[0].userEmail").value("user@example.com"))
                .andExpect(jsonPath("$[0].state").value("ASSIGNED"));
    }
}