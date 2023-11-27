package lt.codeacademy.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private LocalDate dateOfBirth;
    private String jwtToken;
    private Set<RoleDTO> roles;
}

