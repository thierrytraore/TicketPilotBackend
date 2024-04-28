package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.TicketDetailsDto;
import com.exnihilo.domains.entities.Ticket;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TagMapper.class})
public interface TicketDetailsMapper extends BaseMapper<Ticket, TicketDetailsDto> {
    @AfterMapping
    default void linkAssignments(@MappingTarget Ticket ticket) {
        ticket.getAssignments().forEach(assignment -> assignment.setTicket(ticket));
    }
}
