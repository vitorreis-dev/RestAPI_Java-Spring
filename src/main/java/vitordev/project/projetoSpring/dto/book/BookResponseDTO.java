package vitordev.project.projetoSpring.dto.book;

import vitordev.project.projetoSpring.entity.BookThemes;

import java.time.LocalDate;

public record BookResponseDTO(
        Long id,
        String title,
        String author,
        LocalDate year,
        BookThemes theme
) {}
