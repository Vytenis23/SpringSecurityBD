package lt.codeacademy.basketblog.service;

import lt.codeacademy.basketblog.dto.AuthResponse;
import lt.codeacademy.basketblog.dto.LoginRequest;
import lt.codeacademy.basketblog.dto.SignupRequest;
import lt.codeacademy.basketblog.dto.UserDTO;

public interface UserService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(SignupRequest signupRequest);

    UserDTO findByUsername(String login);

}