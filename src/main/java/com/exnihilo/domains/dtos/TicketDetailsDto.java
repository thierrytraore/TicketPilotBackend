package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Assignment;
import com.exnihilo.domains.entities.Tag;
import com.exnihilo.domains.entities.Ticket;
import com.exnihilo.domains.enums.PersonRole;
import com.exnihilo.domains.enums.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link Ticket}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TicketDetailsDto(String id,
                               String label,
                               String description,
                               TicketStatus status,
                               List<TagByTicketDetailsDto> tags,
                               List<AssignmentByTicketDetailsDto> assignments) implements Serializable {
    /**
     * DTO for {@link Tag}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TagByTicketDetailsDto(String id,
                                        Instant createdAt,
                                        Instant updatedAt,
                                        String label) implements Serializable {
    }

    /**
     * DTO for {@link Assignment}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record AssignmentByTicketDetailsDto(String id,
                                               Instant createdAt,
                                               Instant updatedAt,
                                               String personId,
                                               Instant personCreatedAt,
                                               Instant personUpdatedAt,
                                               String personLastName,
                                               String personFirstName,
                                               String personEmail,
                                               PersonRole personRole, String comment) implements Serializable {
    }
}
