package vitordev.project.projetoSpring.dto.person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PersonRequestDTO(
        @NotBlank(message = "Name is required!")
        String name,
        @NotBlank(message = "E-mail is required!")
        @Email(message = "Invalid E-mail format!")
        String email,
        @NotBlank(message = "CPF is required!")
        @Pattern(regexp = "^\\d{11}$", message = "Invalid CPF format!")
        @Size(max=11)
        String cpf,
        @NotBlank(message = "Password is required!")
        @Size(min = 8, max = 50)
        String password
)
{}
