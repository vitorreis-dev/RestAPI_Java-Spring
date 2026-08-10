package vitordev.project.projetoSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import vitordev.project.projetoSpring.dto.request.PersonRequestDTO;
import vitordev.project.projetoSpring.dto.response.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.response.PersonUpdateDTO;
import vitordev.project.projetoSpring.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonRequestDTO dto);

    PersonResponseDTO toDTO(Person entity);

    void updateEntity(PersonUpdateDTO dto, @MappingTarget Person entity);
}
