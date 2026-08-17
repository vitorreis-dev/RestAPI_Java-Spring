package vitordev.project.projetoSpring.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitordev.project.projetoSpring.config.BookControllerDocs;
import vitordev.project.projetoSpring.dto.book.BookRequestDTO;
import vitordev.project.projetoSpring.dto.book.BookResponseDTO;
import vitordev.project.projetoSpring.dto.book.BookUpdateDTO;
import vitordev.project.projetoSpring.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController implements BookControllerDocs {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public List<BookResponseDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public BookResponseDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public BookResponseDTO create(@Valid @RequestBody BookRequestDTO dto) {
        return service.create(dto);
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public BookResponseDTO update(@PathVariable("id") @Valid Long id, @RequestBody
    BookUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Book deleted successfully.");
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().body("All books deleted successfully.");
    }

}
