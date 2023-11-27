package lt.codeacademy.eshop.controller;


import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.config.UserAuthenticationProvider;
import lt.codeacademy.eshop.dto.AuthResponse;
import lt.codeacademy.eshop.dto.LoginRequest;
import lt.codeacademy.eshop.dto.SignupRequest;
import lt.codeacademy.eshop.model.User;
import lt.codeacademy.eshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = userService.login(loginRequest);
        authResponse.setJwtToken(userAuthenticationProvider.createToken(authResponse.getUsername()));
        return ResponseEntity
                .ok(authResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody SignupRequest signupRequest) {
        AuthResponse authResponse = userService.register(signupRequest);
        authResponse.setJwtToken(userAuthenticationProvider.createToken(authResponse.getUsername()));
        return ResponseEntity.created(URI.create("/users/" + authResponse.getId())).body(authResponse);
    }

}
