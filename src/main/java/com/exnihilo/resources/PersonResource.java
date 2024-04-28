package com.exnihilo.resources;

import com.exnihilo.domains.dtos.PersonDto;
import com.exnihilo.domains.dtos.PersonLoginDto;
import com.exnihilo.domains.dtos.PersonRegisterDto;
import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.mappers.PersonMapper;
import com.exnihilo.domains.mappers.PersonRegisterMapper;
import com.exnihilo.resources.impl.BaseResourceImpl;
import com.exnihilo.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.exnihilo.domains.enums.PersonRole.USER;

@RestController
@RequestMapping("/persons")
public class PersonResource extends BaseResourceImpl<PersonDto, String> {

    private final PersonService personService;
    private final PersonRegisterMapper personRegisterMapper;
    private final PersonMapper personMapper;

    @Autowired
    public PersonResource(final PersonService personService, final PersonRegisterMapper personRegisterMapper,
                          final PersonMapper personMapper) {
        super(personService);
        this.personService = personService;
        this.personRegisterMapper = personRegisterMapper;
        this.personMapper = personMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<PersonDto> login(@Valid @RequestBody PersonLoginDto personLoginDto) {
        PersonDto result = personService.getByEmail(personLoginDto.email());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<PersonDto> register(@Valid @RequestBody PersonRegisterDto personRegisterDto) {
        Person person = personRegisterMapper.toEntity(personRegisterDto);
        person.setRole(USER); /* Tous les nouveaux utilisateurs sont obligatoirement des USER */
        PersonDto result = personService.create(personMapper.toDto(person));
        return ResponseEntity.ok(result);
    }

}
