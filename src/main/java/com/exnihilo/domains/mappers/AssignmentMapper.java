package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.AssignmentDto;
import com.exnihilo.domains.entities.Assignment;
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
public interface AssignmentMapper extends BaseMapper<Assignment, AssignmentDto> {
    @Mapping(source = "ticketId", target = "ticket.id")
    @Mapping(source = "personId", target = "person.id")
    Assignment toEntity(AssignmentDto assignmentDto);

    @InheritInverseConfiguration(name = "toEntity")
    AssignmentDto toDto(Assignment assignment);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Assignment partialUpdate(AssignmentDto assignmentDto, @MappingTarget Assignment assignment);
}
