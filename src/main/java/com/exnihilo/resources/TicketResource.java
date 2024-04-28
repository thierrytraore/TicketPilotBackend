package com.exnihilo.resources;

import com.exnihilo.domains.dtos.TicketDto;
import com.exnihilo.resources.impl.BaseResourceImpl;
import com.exnihilo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketResource extends BaseResourceImpl<TicketDto, String> {

    private final TicketService ticketService;

    @Autowired
    public TicketResource(final TicketService ticketService) {
        super(ticketService);
        this.ticketService = ticketService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Long>> getTicketStatistics() {
        return ResponseEntity.ok(ticketService.getAllTicketStatistics());
    }
}
