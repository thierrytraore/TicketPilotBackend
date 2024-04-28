package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.PersonDto;
import com.exnihilo.domains.entities.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper extends BaseMapper<Person, PersonDto> {
    Person toEntity(PersonDto personDto);

    @InheritInverseConfiguration(name = "toEntity")
    PersonDto toDto(Person person);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Person partialUpdate(PersonDto personDto, @MappingTarget Person person);
}