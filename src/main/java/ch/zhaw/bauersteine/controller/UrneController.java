package ch.zhaw.bauersteine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneCreateDTO;
import ch.zhaw.bauersteine.repository.UrneRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class UrneController {

    @Autowired
    UrneRepository urneRepository;

    @PostMapping("/urne")
    public ResponseEntity<Urne> createUrne(
            @RequestBody UrneCreateDTO uDTO) {
        Urne uDAO = new Urne(uDTO.getBeschreibung(), uDTO.getMaterial(), uDTO.getPreis(), uDTO.getInhaltsmenge());
        Urne u = urneRepository.save(uDAO);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping("/urne")
    public ResponseEntity<List<Urne>> getAllUrne(
        @RequestParam(required = false) Double is) {
        List<Urne> allU;
        if (is != null) {
            allU = urneRepository.findByInhaltsmenge(is);
            return new ResponseEntity<>(allU, HttpStatus.OK);
        }else {
        allU = urneRepository.findAll();
        return new ResponseEntity<>(allU, HttpStatus.OK);
        }
    }

    @GetMapping("/urne/{id}")
    public ResponseEntity<Urne> getUrneById(@PathVariable String id) {
        Optional<Urne> optUrne = urneRepository.findById(id);
                // Falls die ID existiert, OK und die Urne zurückgeben
        return optUrne.stream().filter(x -> x.getId().equals(id)).findFirst().map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        // Falls die ID nicht existiert, NOT_FOUND zurückgeben
    }
}