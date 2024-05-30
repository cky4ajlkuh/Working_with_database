package com.example.postgresql.controller;

import com.example.postgresql.dto.PersonDTO;
import com.example.postgresql.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping()
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService service) {
        this.personService = service;
    }

    @PostMapping("/addPerson")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        PersonDTO personDTO1 = personService.createPerson(personDTO);
        return new ResponseEntity<>(personDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<PersonDTO> getPersonById(@RequestParam Long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson")
    public ResponseEntity<Void> deletePersonById(@RequestParam Long id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updatePerson")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO, @RequestParam Long id) {
        personDTO.setId(id);
        return new ResponseEntity<>(personService.updatePerson(personDTO), HttpStatus.ACCEPTED);
    }
}
