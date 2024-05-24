package ch.zhaw.bauersteine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.bauersteine.model.User;
import ch.zhaw.bauersteine.model.UserCreateDTO;
import ch.zhaw.bauersteine.repository.UserRepository;
import ch.zhaw.bauersteine.service.MailValidatorService;
import ch.zhaw.bauersteine.service.RoleService;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserRepository userRepository;
    @Autowired MailValidatorService mailValidatorService;

        @PostMapping("/user")
    public ResponseEntity<User> createUser(
            @RequestBody UserCreateDTO fDTO, @AuthenticationPrincipal Jwt jwt) {
        if (jwt == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        var mailInformation = mailValidatorService.validateEmail(fDTO.getEmail());
        if (mailInformation.isDisposable() || !mailInformation.isDns() || !mailInformation.isFormat()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User fDAO = new User(fDTO.getEmail(), fDTO.getName());
        User f = userRepository.save(fDAO);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

        @GetMapping("/me/user")
    public ResponseEntity<User> getMyUserId(@AuthenticationPrincipal Jwt jwt) {
        String userEmail = jwt.getClaimAsString("email");
        User user = userRepository.findFirstByEmail(userEmail);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
