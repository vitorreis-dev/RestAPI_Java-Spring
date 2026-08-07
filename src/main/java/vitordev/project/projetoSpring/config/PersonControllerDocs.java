package vitordev.project.projetoSpring.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitordev.project.projetoSpring.dto.PersonRequestDTO;
import vitordev.project.projetoSpring.dto.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.PersonUpdateDTO;

import java.util.List;

@Tag(name = "Person", description = "Operations related to people")
public interface PersonControllerDocs {
    @Operation(summary = "Buscar todas as pessoas")
    List<PersonResponseDTO> findAll();

    @Operation(summary = "Buscar pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa encontrada"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    PersonResponseDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Cria uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa criada"),
            @ApiResponse(responseCode = "404", description = "Vishi")
    })
    PersonResponseDTO create(@Valid @RequestBody PersonRequestDTO dto);

    @Operation(summary = "Edita dados de uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dados editados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Vishi")
    })
    PersonResponseDTO update(@PathVariable("id") Long id, @RequestBody PersonUpdateDTO dto);

    @Operation(summary = "Exclui pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa excluida!"),
            @ApiResponse(responseCode = "404", description = "Vishi")
    })
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @Operation(summary = "Exclui todas as pessoas cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoas excluídas"),
            @ApiResponse(responseCode = "404", description = "Vishi")
    })
    ResponseEntity<?> deleteAll();
}
