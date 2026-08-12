package vitordev.project.projetoSpring.dto.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String password) {
}
