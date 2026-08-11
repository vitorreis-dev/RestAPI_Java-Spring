package vitordev.project.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitordev.project.projetoSpring.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
