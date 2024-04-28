package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.PersonRegisterDto;
import com.exnihilo.domains.entities.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonRegisterMapper extends BaseMapper<Person, PersonRegisterDto> {
    Person toEntity(PersonRegisterDto personRegisterDto);

    PersonRegisterDto toDto(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person partialUpdate(PersonRegisterDto personRegisterDto, @MappingTarget Person person);
}