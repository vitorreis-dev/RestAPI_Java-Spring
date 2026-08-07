package vitordev.project.projetoSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import vitordev.project.projetoSpring.dto.PersonRequestDTO;
import vitordev.project.projetoSpring.dto.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.PersonUpdateDTO;
import vitordev.project.projetoSpring.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonRequestDTO dto);

    PersonResponseDTO toDTO(Person entity);

    void updateEntity(PersonUpdateDTO dto, @MappingTarget Person entity);
}
