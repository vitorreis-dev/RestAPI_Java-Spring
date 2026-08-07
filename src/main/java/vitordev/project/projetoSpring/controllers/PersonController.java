package vitordev.project.projetoSpring.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import vitordev.project.projetoSpring.dto.PersonRequestDTO;
import vitordev.project.projetoSpring.dto.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.PersonUpdateDTO;
import vitordev.project.projetoSpring.service.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController implements vitordev.project.projetoSpring.config.PersonControllerDocs {

    private PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public List<PersonResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public PersonResponseDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public PersonResponseDTO create(@Valid @RequestBody PersonRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public PersonResponseDTO update(@PathVariable("id") Long id, @RequestBody PersonUpdateDTO dto) {
        return service.update(id,dto);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
