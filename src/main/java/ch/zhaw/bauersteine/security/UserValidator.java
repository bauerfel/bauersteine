package ch.zhaw.bauersteine.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import ch.zhaw.bauersteine.model.User;
import ch.zhaw.bauersteine.repository.UserRepository;



class UserValidator implements OAuth2TokenValidator<Jwt> {

    UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        OAuth2Error error = new OAuth2Error("invalid_token", "The required email is missing", null);

        String userEmail = jwt.getClaimAsString("email");
        if (userEmail != null && !userEmail.equals("")) {
            User f = userRepository.findFirstByEmail(userEmail);
            if (f == null) {
                String username = jwt.getClaimAsString("nickname");
                userRepository.save(new User(userEmail, username));
                System.out.println("Creating new user:");
                System.out.println("  - name:  " + username);
                System.out.println("  - email: " + userEmail);
            }
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
    }
}
