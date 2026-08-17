package vitordev.project.projetoSpring.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitordev.project.projetoSpring.dto.person.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.person.PersonUpdateDTO;

import java.util.List;

@Tag(name = "Person", description = "Operations related to people")
@SecurityRequirement(name = "bearer-key")
public interface PersonControllerDocs {
    @Operation(summary = "Buscar todas as pessoas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "People found successfully"),
            @ApiResponse(responseCode = "404", description = "No records found!")
    })
    List<PersonResponseDTO> findAll();

    @Operation(summary = "Buscar pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    PersonResponseDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Edita os dados de uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person data updated successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    PersonResponseDTO update(@PathVariable("id") Long id, @RequestBody PersonUpdateDTO dto);

    @Operation(summary = "Excluir pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No records found for this ID!")
    })
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @Operation(summary = "Excluir todas as pessoas cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All people deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No records found to delete!")
    })
    ResponseEntity<?> deleteAll();
}
