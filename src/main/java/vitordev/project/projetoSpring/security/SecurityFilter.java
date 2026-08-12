package vitordev.project.projetoSpring.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vitordev.project.projetoSpring.entity.Person;
import vitordev.project.projetoSpring.repository.PersonRepository;
import vitordev.project.projetoSpring.service.TokenService;

import java.io.IOException;

@Component
public class SecurityFilter
        extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final PersonRepository repository;

    public SecurityFilter(
            TokenService tokenService,
            PersonRepository repository) {

        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String token = recoverToken(request);

        if (token != null) {
            try {
                String email = tokenService.validateToken(token);

                Person person = repository
                        .findByEmail(email)
                        .orElse(null);

                if (person != null) {
                    UserDetails userDetails =
                            org.springframework.security.core.userdetails.User
                                    .withUsername(person.getEmail())
                                    .password(person.getPassword())
                                    .roles("USER")
                                    .build();

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(authentication);
                }
            } catch (Exception ignored) {
                // Token inválido/expirado: segue sem autenticação no contexto
            }
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {

        String authorization =
                request.getHeader("Authorization");

        if (authorization == null) {
            return null;
        }

        if (!authorization.startsWith("Bearer ")) {
            return null;
        }

        return authorization.substring(7);
    }
}
