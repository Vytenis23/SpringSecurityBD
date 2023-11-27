package lt.codeacademy.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequest {

    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private LocalDate dateOfBirth;

}
