package vitordev.project.projetoSpring.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "Title is required!")
        String title,
        @NotBlank(message = "Author is required!")
        String author,
        @NotNull(message = "Year is required!")
        LocalDate year,
        @NotNull(message = "Theme ID is required!")
        Long themeID) {
}
