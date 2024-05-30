package com.example.postgresql.service;

import com.example.postgresql.dto.PersonDTO;
import com.example.postgresql.mapper.PersonMapper;
import com.example.postgresql.model.Person;
import com.example.postgresql.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private final PersonRepository repository;

    private final PersonMapper mapper;

    public PersonService(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PersonDTO getPersonById(Long id) {
        PersonDTO personDTO = new PersonDTO();
        if (repository.findById(id).isPresent()) {
            personDTO = mapper.toDTO(repository.findById(id).get());
        }
        return personDTO;
    }

    public List<PersonDTO> getAllPersons() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = mapper.toEntity(personDTO);
        Person createdPerson = repository.save(person);
        return mapper.toDTO(createdPerson);
    }

    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person person = mapper.toEntity(personDTO);
        Person updatePerson = repository.save(person);
        return mapper.toDTO(updatePerson);
    }

    public void deletePersonById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
