package ch.zhaw.bauersteine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneCreateDTO;
import ch.zhaw.bauersteine.model.UrneStateAggregation;
import ch.zhaw.bauersteine.repository.UrneRepository;

public class UrneControllerTest {

    @Mock
    private UrneRepository urneRepository;

    @InjectMocks
    private UrneController urneController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    //todo: testCreateUrne
    // @Test
    // public void testCreateUrne() {
    //     UrneCreateDTO uDTO = new UrneCreateDTO("Beschreibung", "Material", 10.0, 10.0);
    //     Urne uDAO = new Urne(uDTO.getBeschreibung(), uDTO.getMaterial(), uDTO.getPreis(), uDTO.getInhaltsmenge());
    //     Urne u = new Urne("Beschreibung", "Material", 10.0, 100);
    //     when(urneRepository.save(uDAO)).thenReturn(u);

    //     ResponseEntity<Urne> response = urneController.createUrne(uDTO);

    //     assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    //     assertThat(response.getBody()).isEqualTo(u);
    // }

    @Test
    public void testGetAllUrne() {
        List<Urne> allU = new ArrayList<>();
        allU.add(new Urne("Beschreibung1", "Material1", 10.0, 100));
        allU.add(new Urne("Beschreibung2", "Material2", 20.0, 200));
        when(urneRepository.findAll()).thenReturn(allU);

        ResponseEntity<List<Urne>> response = urneController.getAllUrne(null);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(allU);
    }

    @Test
    public void testGetAllUrneWithInhaltsmenge() {
        List<Urne> allU = new ArrayList<>();
        allU.add(new Urne("Beschreibung1", "Material1", 10.0, 100));
        when(urneRepository.findByInhaltsmenge(100.0)).thenReturn(allU);

        ResponseEntity<List<Urne>> response = urneController.getAllUrne(100.0);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(allU);
    }
  

    // todo: testGetUrneById 
    

    @Test
    public void testGetUrneByIdNotFound() {
        String id = "1";
        Optional<Urne> optUrne = Optional.empty();
        when(urneRepository.findById(id)).thenReturn(optUrne);

        ResponseEntity<Urne> response = urneController.getUrneById(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
    // todo: ID wird noch als null ausgegeben.
    // @Test
    // public void testGetUrneStateAggregation() {
    //     List<UrneStateAggregation> aggregation = new ArrayList<>();
    //     aggregation.add(new UrneStateAggregation());
    //     aggregation.add(new UrneStateAggregation());
    //     when(urneRepository.getUrneStateAggregation()).thenReturn(aggregation);

    //     List<UrneStateAggregation> result = urneController.getUrneStateAggregation();

    //     assertThat(result).isEqualTo(aggregation);
    // }
}