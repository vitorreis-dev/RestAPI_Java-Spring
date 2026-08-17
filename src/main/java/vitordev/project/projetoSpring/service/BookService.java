package vitordev.project.projetoSpring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitordev.project.projetoSpring.dto.book.BookResponseDTO;
import vitordev.project.projetoSpring.dto.book.BookUpdateDTO;
import vitordev.project.projetoSpring.dto.book.BookRequestDTO;
import vitordev.project.projetoSpring.entity.Book;
import vitordev.project.projetoSpring.entity.BookThemes;
import vitordev.project.projetoSpring.exceptions.custom.ResourceNotFoundException;
import vitordev.project.projetoSpring.mapper.BookMapper;
import vitordev.project.projetoSpring.repository.BookRepository;
import vitordev.project.projetoSpring.repository.BookThemesRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {
    private BookMapper mapper;
    private BookRepository repository;
    private BookThemesRepository themesRepository;

    public BookService(BookMapper mapper, BookRepository repository, BookThemesRepository themesRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.themesRepository = themesRepository;
    }

    private final Logger logger = Logger.getLogger(BookService.class.getName());

    @Transactional(readOnly = true)
    public List<BookResponseDTO> findAll() {

        List<Book> books = repository.findAll();

        if(books.isEmpty()){
            throw new ResourceNotFoundException("No records found!");
        }

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public BookResponseDTO findById(Long id) {

        Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return mapper.toDTO(book);
    }

    public BookResponseDTO create(BookRequestDTO dto) {

        logger.info("Creating one Book!");

        Book entity = mapper.toEntity(dto);
        applyTheme(entity, dto.themeID());

        Book saved = repository.save(entity);

        return mapper.toDTO(saved);
    }

    public BookResponseDTO update(Long id, BookUpdateDTO dto) {

        logger.info("Updating one Book!");
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        mapper.updateEntity(dto, entity);
        applyTheme(entity, dto.themeID());

        Book updatedBook = repository.save(entity);

        return mapper.toDTO(updatedBook);
    }

    private void applyTheme(Book entity, Long themeID) {
        if (themeID == null) {
            throw new ResourceNotFoundException("Theme ID is required!");
        }
        BookThemes theme = themesRepository.findById(themeID).orElseThrow(() -> new ResourceNotFoundException("No theme found for this ID!"));
        entity.setTheme(theme);
    }

    public void deleteAll(){
        if(repository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No records found to delete!");
        }
        repository.deleteAll();
    }

    public void delete(Long id) {

        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("No records found for this ID!");
        }

        repository.deleteById(id);
    }
}
