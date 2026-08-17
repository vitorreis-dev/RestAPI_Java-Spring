package vitordev.project.projetoSpring.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import vitordev.project.projetoSpring.dto.person.LoginRequestDTO;
import vitordev.project.projetoSpring.dto.person.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.person.RegisterRequestDTO;
import vitordev.project.projetoSpring.dto.person.TokenResponseDTO;

@Tag(name = "Authentication", description = "Endpoints responsible for user registration and authentication.")
public interface AuthControllerDocs {

    @Operation(
            summary = "Cadastrar usuário",
            description = "Creates a new user account."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully registered."),
            @ApiResponse(responseCode = "409", description = "User or CPF already exists.")
    })
    ResponseEntity<PersonResponseDTO> register(@Valid @RequestBody RegisterRequestDTO dto);

    @Operation(
            summary = "Realizar login",
            description = "Authenticates a user and returns an access token."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User successfully authenticated."),
            @ApiResponse(responseCode = "401", description = "Invalid credentials.")
    })
    ResponseEntity<TokenResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto);
}