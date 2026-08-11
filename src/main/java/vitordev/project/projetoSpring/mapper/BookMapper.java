package vitordev.project.projetoSpring.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import vitordev.project.projetoSpring.dto.book.BookRequestDTO;
import vitordev.project.projetoSpring.dto.book.BookResponseDTO;
import vitordev.project.projetoSpring.dto.book.BookUpdateDTO;
import vitordev.project.projetoSpring.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookThemes", ignore = true)
    Book toEntity(BookRequestDTO dto);

    @Mapping(source = "bookThemes", target = "themes")
    BookResponseDTO toDTO(Book entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookThemes", ignore = true)
    void updateEntity(BookUpdateDTO dto, @MappingTarget Book entity);
}
