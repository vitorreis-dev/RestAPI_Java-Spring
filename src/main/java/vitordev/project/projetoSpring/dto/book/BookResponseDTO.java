package vitordev.project.projetoSpring.dto.book;

import vitordev.project.projetoSpring.entity.BookThemes;

import java.time.LocalDate;
import java.util.Set;

public record BookResponseDTO(
        Long id,
        String title,
        String author,
        LocalDate year,
        Set<BookThemes> themes
) {}
