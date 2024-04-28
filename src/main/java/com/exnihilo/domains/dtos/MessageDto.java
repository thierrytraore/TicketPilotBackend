package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Message}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageDto(
        String id,
        @NotNull String assignmentId,
        @NotNull @NotBlank String content,
        Instant createdAt,
        Instant updatedAt
) implements Serializable {
    public MessageDto(@NotNull String assignmentId, @NotNull @NotBlank String content) {
        this(null, assignmentId, content, Instant.now(), Instant.now());
    }
}
