package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Ticket;
import com.exnihilo.domains.enums.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Ticket}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TicketDto(
        String id,
        @NotNull String label,
        @NotNull String description,
        @NotNull TicketStatus status,
        @NotNull List<TagDto> tags,
        @NotNull String openedById,
        @NotNull String closedById
) implements Serializable {

    public TicketDto(@NotNull String label, @NotNull String description, @NotNull TicketStatus status, @NotNull List<TagDto> tags, @NotNull String openedById, @NotNull String closedById) {
        this(null, label, description, status, tags, openedById, closedById);
    }

}
