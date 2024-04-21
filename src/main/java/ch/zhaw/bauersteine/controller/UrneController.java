package ch.zhaw.bauersteine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneCreateDTO;
import ch.zhaw.bauersteine.repository.UrneRepository;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UrneController {

    @Autowired
    UrneRepository urneRepository;

    @PostMapping("/urne")
    public ResponseEntity<Urne> createUrne(
        @RequestBody UrneCreateDTO uDTO) {
        Urne uDAO = new Urne(uDTO.getBeschreibung(), uDTO.getMaterial(), uDTO.getPreis());
        Urne u = urneRepository.save(uDAO);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}