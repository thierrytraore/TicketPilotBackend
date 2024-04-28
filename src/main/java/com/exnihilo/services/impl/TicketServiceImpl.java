package com.exnihilo.services.impl;

import com.exnihilo.domains.dtos.TicketDetailsDto;
import com.exnihilo.domains.dtos.TicketDto;
import com.exnihilo.domains.entities.Ticket;
import com.exnihilo.domains.enums.TicketStatus;
import com.exnihilo.domains.mappers.TicketDetailsMapper;
import com.exnihilo.domains.mappers.TicketMapper;
import com.exnihilo.repositories.TicketRepository;
import com.exnihilo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketDto, String> implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketDetailsMapper ticketDetailsMapper;

    @Autowired
    public TicketServiceImpl(final TicketRepository ticketRepository,
                             final TicketMapper ticketMapper, final TicketDetailsMapper ticketDetailsMapper) {
        super(ticketRepository, ticketMapper);
        this.ticketRepository = ticketRepository;
        this.ticketDetailsMapper = ticketDetailsMapper;
    }

    @Override
    public List<TicketDetailsDto> getAllTicketDetails() {
        return ticketRepository.findAll().stream().map(ticketDetailsMapper::toDto).toList();
    }

    @Override
    public Map<String, Long> getAllTicketStatistics() {
        Map<String, Long> result = new HashMap<>();
        for (TicketStatus ticketStatus : TicketStatus.values()) {
            result.put(ticketStatus.name(), ticketRepository.countByStatus(ticketStatus));
        }
        return result;
    }

}
