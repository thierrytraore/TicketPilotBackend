package com.exnihilo.services;

import com.exnihilo.domains.dtos.TicketDetailsDto;
import com.exnihilo.domains.dtos.TicketDto;

import java.util.List;
import java.util.Map;

public interface TicketService extends BaseService<TicketDto, String> {

    List<TicketDetailsDto> getAllTicketDetails();

    Map<String, Long> getAllTicketStatistics();
}