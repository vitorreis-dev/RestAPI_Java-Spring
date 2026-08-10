package vitordev.project.projetoSpring.service;

import org.springframework.stereotype.Service;
import vitordev.project.projetoSpring.dto.request.PersonRequestDTO;
import vitordev.project.projetoSpring.dto.response.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.response.PersonUpdateDTO;
import vitordev.project.projetoSpring.entity.Person;
import vitordev.project.projetoSpring.exceptions.custom.BusinessException;
import vitordev.project.projetoSpring.exceptions.custom.ResourceNotFoundException;
import vitordev.project.projetoSpring.mapper.PersonMapper;
import vitordev.project.projetoSpring.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private PersonMapper mapper;

    private PersonRepository repository;

    public PersonServices(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonResponseDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public PersonResponseDTO findById(Long id) {

        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return mapper.toDTO(person);
    }

    public PersonResponseDTO create(PersonRequestDTO dto) {

        logger.info("Creating one Person!");

        Person entity = mapper.toEntity(dto);

        boolean cpfExists = repository.existsByCpf(entity.getCpf());
        boolean emailExists = repository.existsByEmail(entity.getEmail());

        if (cpfExists && emailExists) {
            throw new BusinessException("This CPF and E-mail already exists!");
        }

        if (emailExists) {
            throw new BusinessException("This E-mail already exists!");
        }

        if (cpfExists) {
            throw new BusinessException("This CPF already exists!");
        }


        Person saved = repository.save(entity);

        return mapper.toDTO(saved);
    }

    public PersonResponseDTO update(Long id, PersonUpdateDTO dto) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        mapper.updateEntity(dto,entity);

        Person saved = repository.save(entity);

        return mapper.toDTO(saved);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


