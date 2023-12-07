package lt.codeacademy.basketblog.config;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.basketblog.model.Role;
import lt.codeacademy.basketblog.model.User;
import lt.codeacademy.basketblog.repository.RoleRepository;
import lt.codeacademy.basketblog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdminUserRunner implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role role = roleRepository.findRoleByName("ADMIN").orElseThrow(RuntimeException::new);
        User user = new User();
        user.setName("Admin");
        user.setEmail("admin@yopmail.com");
        user.setUsername("admin");
        user.setLastName("Admin");
        user.setDateOfBirth(LocalDate.now());
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap("admin")));
        user.setRoles(Set.of(role));
        userRepository.save(user);
    }
}
