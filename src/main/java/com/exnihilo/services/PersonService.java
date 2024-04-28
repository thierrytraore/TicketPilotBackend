package com.exnihilo.services;

import com.exnihilo.domains.dtos.PersonDto;

public interface PersonService extends BaseService<PersonDto, String> {

    PersonDto getByEmail(String email);

}
