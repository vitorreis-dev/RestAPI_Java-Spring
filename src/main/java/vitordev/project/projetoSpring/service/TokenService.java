package vitordev.project.projetoSpring.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vitordev.project.projetoSpring.entity.Person;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Person person) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create().withIssuer("api").withSubject(person.getEmail()).withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS)).sign(algorithm);
    }
}