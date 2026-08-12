package vitordev.project.projetoSpring.dto.book;

import java.time.LocalDate;

public record BookUpdateDTO(
        String title,
        String author,
        LocalDate year,
        Long themeID) {
}
