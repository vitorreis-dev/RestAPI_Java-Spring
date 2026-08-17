package vitordev.project.projetoSpring.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitordev.project.projetoSpring.dto.book.BookRequestDTO;
import vitordev.project.projetoSpring.dto.book.BookResponseDTO;
import vitordev.project.projetoSpring.dto.book.BookUpdateDTO;

import java.util.List;

@Tag(name="Book", description="Operations related to books")
@SecurityRequirement(name="bearer-key")
public interface BookControllerDocs {

    @Operation(summary = "Buscar todos os livros")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books found successfully"),
            @ApiResponse(responseCode = "404", description = "No records found!")
    })
    List<BookResponseDTO> findAll();


    @Operation(summary = "Buscar livro por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book found successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    BookResponseDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Criar um novo livro")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Book created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    BookResponseDTO create(@Valid @RequestBody BookRequestDTO dto);

    @Operation(summary = "Editar livro por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    BookResponseDTO update(@PathVariable("id") @Valid Long id, @RequestBody BookUpdateDTO dto);

    @Operation(summary = "Excluir livro por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @Operation(summary = "Excluir todos os livros")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "All books deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No records found to delete!")
    })
    ResponseEntity<?> deleteAll();
}
