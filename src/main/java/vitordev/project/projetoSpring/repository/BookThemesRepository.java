package vitordev.project.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitordev.project.projetoSpring.entity.BookThemes;

@Repository
public interface BookThemesRepository extends JpaRepository<BookThemes, Long> {
}
