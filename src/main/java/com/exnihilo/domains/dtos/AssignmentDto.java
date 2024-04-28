package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Assignment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link Assignment}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssignmentDto(
        String id,
        @NotBlank String personId,
        @NotBlank String ticketId,
        String comment
) implements Serializable {

    public AssignmentDto(@NotBlank String personId, @NotBlank String ticketId, String comment) {
        this(null, personId, ticketId, comment);
    }

}
