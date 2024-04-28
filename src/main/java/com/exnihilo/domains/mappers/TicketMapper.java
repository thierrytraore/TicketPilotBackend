package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.TicketDto;
import com.exnihilo.domains.entities.Ticket;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = TagMapper.class)
public interface TicketMapper extends BaseMapper<Ticket, TicketDto> {
    @Override
    @Mapping(source = "closedById", target = "closedBy.id")
    @Mapping(source = "openedById", target = "openedBy.id")
    Ticket toEntity(TicketDto ticketDto);

    @Override
    @InheritInverseConfiguration(name = "toEntity")
    TicketDto toDto(Ticket ticket);

    @Override
    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Ticket partialUpdate(TicketDto ticketDto, @MappingTarget Ticket ticket);
}
