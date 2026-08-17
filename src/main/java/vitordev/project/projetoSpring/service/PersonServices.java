package vitordev.project.projetoSpring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vitordev.project.projetoSpring.dto.person.PersonResponseDTO;
import vitordev.project.projetoSpring.dto.person.PersonUpdateDTO;
import vitordev.project.projetoSpring.entity.Person;
import vitordev.project.projetoSpring.exceptions.custom.ResourceNotFoundException;
import vitordev.project.projetoSpring.mapper.PersonMapper;
import vitordev.project.projetoSpring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServices implements UserDetailsService {

    private final PersonMapper mapper;

    private final PersonRepository repository;

    public PersonServices(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return org.springframework.security.core.userdetails.User.withUsername(person.getEmail()).password(person.getPassword()).roles("USER").build();
    }

    public List<PersonResponseDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public PersonResponseDTO findById(Long id) {

        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return mapper.toDTO(person);
    }

    public PersonResponseDTO update(Long id, PersonUpdateDTO dto) {

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        mapper.updateEntity(dto,entity);

        Person saved = repository.save(entity);

        return mapper.toDTO(saved);
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

        repository.deleteById(id);;
    }
}


