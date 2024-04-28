package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.MessageDto;
import com.exnihilo.domains.entities.Message;
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
public interface MessageMapper extends BaseMapper<Message, MessageDto> {
    @Mapping(source = "assignmentId", target = "assignment.id")
    @Mapping(source = "content", target = "content")
    Message toEntity(MessageDto messageDto);

    @InheritInverseConfiguration(name = "toEntity")
    MessageDto toDto(Message message);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Message partialUpdate(MessageDto messageDto, @MappingTarget Message message);
}
