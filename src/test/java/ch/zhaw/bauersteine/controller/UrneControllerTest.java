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

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneCreateDTO;
import ch.zhaw.bauersteine.model.UrneStateAggregation;
import ch.zhaw.bauersteine.repository.UrneRepository;

@WebMvcTest(UrneController.class)
class UrneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrneRepository urneRepository;

    @Mock
    private Jwt jwt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser(roles = "prod")
    void testCreateUrne() throws Exception {
        UrneCreateDTO urneCreateDTO = new UrneCreateDTO("testtest", "Testmaterial", 2500, 5);
        Urne urne = new Urne("testtest", "Testmaterial", 2500, 5, "prod@a.ch");
        urne.setId("664cfce8df9b051e44068b74");

        when(urneRepository.save(any(Urne.class))).thenReturn(urne);
        when(jwt.getClaimAsStringList("user_roles")).thenReturn(Collections.singletonList("prod"));
        when(jwt.getClaimAsString("email")).thenReturn("prod@a.ch");

        mockMvc.perform(post("/api/urne")
                .with(SecurityMockMvcRequestPostProcessors.jwt().jwt(jwt))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(urneCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("664cfce8df9b051e44068b74"))
                .andExpect(jsonPath("$.beschreibung").value("testtest"))
                .andExpect(jsonPath("$.material").value("Testmaterial"))
                .andExpect(jsonPath("$.preis").value(2500))
                .andExpect(jsonPath("$.inhaltsmenge").value(5))
                .andExpect(jsonPath("$.state").value("AVAILABLE"))
                .andExpect(jsonPath("$.userEmail").value("prod@a.ch"));
    }

    @Test
    @WithMockUser(roles = "user")
    void testCreateUrneForbidden() throws Exception {
        UrneCreateDTO urneCreateDTO = new UrneCreateDTO("testtest", "Testmaterial", 2500, 5);

        when(jwt.getClaimAsStringList("user_roles")).thenReturn(Collections.singletonList("user"));
        when(jwt.getClaimAsString("email")).thenReturn("user@a.ch");

        mockMvc.perform(post("/api/urne")
                .with(SecurityMockMvcRequestPostProcessors.jwt().jwt(jwt))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(urneCreateDTO)))
                .andExpect(status().isForbidden());
    }

    //GetAll
    @Test
    @WithMockUser
    void testGetAllUrne() throws Exception {
        Urne urne1 = new Urne("test1", "Material1", 1000, 3, "user1@example.com");
        urne1.setId("1");
        Urne urne2 = new Urne("test2", "Material2", 2000, 5, "user2@example.com");
        urne2.setId("2");
        List<Urne> urneList = Arrays.asList(urne1, urne2);

        when(urneRepository.findAll()).thenReturn(urneList);

        mockMvc.perform(get("/api/urne")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].beschreibung").value("test1"))
                .andExpect(jsonPath("$[0].material").value("Material1"))
                .andExpect(jsonPath("$[0].preis").value(1000))
                .andExpect(jsonPath("$[0].inhaltsmenge").value(3))
                .andExpect(jsonPath("$[0].userEmail").value("user1@example.com"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].beschreibung").value("test2"))
                .andExpect(jsonPath("$[1].material").value("Material2"))
                .andExpect(jsonPath("$[1].preis").value(2000))
                .andExpect(jsonPath("$[1].inhaltsmenge").value(5))
                .andExpect(jsonPath("$[1].userEmail").value("user2@example.com"));
    }

    @Test
    @WithMockUser
    void testGetAllUrneWithInhaltsmenge() throws Exception {
        Urne urne = new Urne("test1", "Material1", 1000, 5, "user1@example.com");
        urne.setId("1");
        List<Urne> urneList = Collections.singletonList(urne);

        when(urneRepository.findByInhaltsmenge(5.0)).thenReturn(urneList);

        mockMvc.perform(get("/api/urne")
                .param("is", "5.0")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].beschreibung").value("test1"))
                .andExpect(jsonPath("$[0].material").value("Material1"))
                .andExpect(jsonPath("$[0].preis").value(1000))
                .andExpect(jsonPath("$[0].inhaltsmenge").value(5))
                .andExpect(jsonPath("$[0].userEmail").value("user1@example.com"));
    }

    //GetById
    @Test
    @WithMockUser
    void testGetUrneById() throws Exception {
        Urne urne = new Urne("test1", "Material1", 1000, 5, "user1@example.com");
        urne.setId("1");

        when(urneRepository.findById("1")).thenReturn(Optional.of(urne));

        mockMvc.perform(get("/api/urne/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.beschreibung").value("test1"))
                .andExpect(jsonPath("$.material").value("Material1"))
                .andExpect(jsonPath("$.preis").value(1000))
                .andExpect(jsonPath("$.inhaltsmenge").value(5))
                .andExpect(jsonPath("$.userEmail").value("user1@example.com"));
    }

    @Test
    @WithMockUser
    void testGetUrneByIdNotFound() throws Exception {
        when(urneRepository.findById("1")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/urne/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    //Aggregation
    @Test
    @WithMockUser
    void testGetUrneStateAggregation() throws Exception {
        UrneStateAggregation aggregation1 = new UrneStateAggregation("1", Arrays.asList("urn1", "urn2"), "2");
        UrneStateAggregation aggregation2 = new UrneStateAggregation("2", Arrays.asList("urn3"), "1");
        List<UrneStateAggregation> aggregationList = Arrays.asList(aggregation1, aggregation2);
    
        when(urneRepository.getUrneStateAggregation()).thenReturn(aggregationList);
    
        mockMvc.perform(get("/api/urne/aggregation/state")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].urneIds[0]").value("urn1"))
                .andExpect(jsonPath("$[0].urneIds[1]").value("urn2"))
                .andExpect(jsonPath("$[0].count").value("2"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].urneIds[0]").value("urn3"))
                .andExpect(jsonPath("$[1].count").value("1"));
    }
}
