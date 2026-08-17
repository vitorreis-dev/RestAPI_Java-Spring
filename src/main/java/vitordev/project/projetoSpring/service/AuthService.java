package vitordev.project.projetoSpring.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vitordev.project.projetoSpring.dto.person.LoginRequestDTO;
import vitordev.project.projetoSpring.dto.person.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.person.RegisterRequestDTO;
import vitordev.project.projetoSpring.entity.Person;
import vitordev.project.projetoSpring.exceptions.custom.BusinessException;
import vitordev.project.projetoSpring.exceptions.custom.ConflictException;
import vitordev.project.projetoSpring.exceptions.custom.InvalidCredentialsException;
import vitordev.project.projetoSpring.mapper.PersonMapper;
import vitordev.project.projetoSpring.repository.PersonRepository;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private PersonMapper mapper;
    private PersonRepository repository;
    private PasswordEncoder passwordEncoder;

    public AuthService(PersonRepository personRepository, PasswordEncoder passwordEncoder, PersonMapper mapper, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.repository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public PersonResponseDTO register(RegisterRequestDTO dto){

        Person entity = mapper.toEntity(dto);

        boolean cpfExists = repository.existsByCpf(entity.getCpf());
        boolean emailExists = repository.existsByEmail(entity.getEmail());

        if (cpfExists && emailExists) {
            throw new ConflictException("This CPF and E-mail already exists!");
        }

        if (emailExists) {
            throw new ConflictException("This E-mail already exists!");
        }

        if (cpfExists) {
            throw new ConflictException("This CPF already exists!");
        }

        entity.setPassword(passwordEncoder.encode(dto.password()));

        Person saved = repository.save(entity);

        return mapper.toDTO(saved);

    }

    public String login(LoginRequestDTO dto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));
        } catch (BadCredentialsException | AuthenticationServiceException ex) {
            throw new InvalidCredentialsException("E-mail ou senha inválidos");
        }

        Person person = repository.findByEmail(dto.email())
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        return tokenService.generateToken(person);
    }
}
