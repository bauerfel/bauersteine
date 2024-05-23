package ch.zhaw.bauersteine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.bauersteine.model.User;
import ch.zhaw.bauersteine.model.UserCreateDTO;
import ch.zhaw.bauersteine.repository.UserRepository;
import ch.zhaw.bauersteine.service.RoleService;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserRepository UserRepository;
        @PostMapping("/user")
    public ResponseEntity<User> createUser(
            @RequestBody UserCreateDTO fDTO, @AuthenticationPrincipal Jwt jwt) {
        if (jwt == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        User fDAO = new User(fDTO.getEmail(), fDTO.getName());
        User f = UserRepository.save(fDAO);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }
}
