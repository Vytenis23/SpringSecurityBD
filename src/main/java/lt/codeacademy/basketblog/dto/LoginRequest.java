package lt.codeacademy.basketblog.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
