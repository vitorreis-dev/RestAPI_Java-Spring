package vitordev.project.projetoSpring.dto.book;

import java.time.LocalDate;
import java.util.Set;

public record BookUpdateDTO(
        String title,
        String author,
        LocalDate year,
        Set<Long> themeIDs) {
}
