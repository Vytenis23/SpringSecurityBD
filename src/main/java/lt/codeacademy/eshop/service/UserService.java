package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.dto.AuthResponse;
import lt.codeacademy.eshop.dto.LoginRequest;
import lt.codeacademy.eshop.dto.SignupRequest;
import lt.codeacademy.eshop.dto.UserDTO;

public interface UserService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(SignupRequest signupRequest);

    UserDTO findByUsername(String login);

}