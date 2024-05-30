package com.example.postgresql.mapper;

import com.example.postgresql.dto.PersonDTO;
import com.example.postgresql.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
