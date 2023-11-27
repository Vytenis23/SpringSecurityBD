package lt.codeacademy.eshop.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.dto.*;
import lt.codeacademy.eshop.exception.AppException;
import lt.codeacademy.eshop.model.Role;
import lt.codeacademy.eshop.model.User;
import lt.codeacademy.eshop.repository.RoleRepository;
import lt.codeacademy.eshop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user = userRepository.findUserByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(CharBuffer.wrap(loginRequest.getPassword()), user.getPassword())) {
            throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
        }
        Set<RoleDTO> roles = user.getRoles().stream().map(role -> new RoleDTO(role.getId(), role.getName())).collect(Collectors.toSet());
        return new AuthResponse(user.getId(), user.getName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getDateOfBirth(), "", roles);
    }

    @Override
    @Transactional
    public AuthResponse register(SignupRequest signupRequest) {
        Optional<User> optionalUser = userRepository.findUserByUsername(signupRequest.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("Username already taken", HttpStatus.BAD_REQUEST);
        }

        Role userRole = roleRepository.findRoleByName("USER")
                .orElseThrow(() -> new AppException("Role not found", HttpStatus.NOT_FOUND));

        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        user.setLastName(signupRequest.getLastName());
        user.setDateOfBirth(signupRequest.getDateOfBirth());
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signupRequest.getPassword())));
        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);
        Set<RoleDTO> roles = savedUser.getRoles().stream().map(role -> new RoleDTO(role.getId(), role.getName())).collect(Collectors.toSet());
        return new AuthResponse(savedUser.getId(), savedUser.getName(), savedUser.getLastName(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getDateOfBirth(), "", roles);
    }

    @Override
    public UserDTO findByUsername(String login) {
        User user = userRepository.findUserByUsername(login)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        return new UserDTO(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getDateOfBirth());
    }

}