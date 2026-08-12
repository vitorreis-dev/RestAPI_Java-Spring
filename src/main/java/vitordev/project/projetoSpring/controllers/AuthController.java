package vitordev.project.projetoSpring.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitordev.project.projetoSpring.dto.person.LoginRequestDTO;
import vitordev.project.projetoSpring.dto.person.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.person.RegisterRequestDTO;
import vitordev.project.projetoSpring.dto.person.TokenResponseDTO;
import vitordev.project.projetoSpring.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<PersonResponseDTO> register(
            @Valid @RequestBody RegisterRequestDTO dto) {

        PersonResponseDTO response = authService.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto) {

        String token = authService.login(dto);

        return ResponseEntity.ok(
                new TokenResponseDTO(token)
        );
    }
}
