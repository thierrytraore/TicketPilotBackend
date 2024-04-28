package com.exnihilo.services.impl;

import com.exnihilo.domains.dtos.PersonDto;
import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.mappers.PersonMapper;
import com.exnihilo.repositories.PersonRepository;
import com.exnihilo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonDto, String> implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository, final PersonMapper personMapper) {
        super(personRepository, personMapper);
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto getByEmail(String email) {
        Optional.ofNullable(email).orElseThrow(() -> new IllegalArgumentException("Cannot find entity: argument 'email' is null."));
        Person person = personRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Entity not found with email '" + email + "'."));
        return personMapper.toDto(person);
    }
}
