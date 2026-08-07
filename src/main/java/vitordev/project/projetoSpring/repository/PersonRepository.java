package vitordev.project.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitordev.project.projetoSpring.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
