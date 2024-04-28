package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Tag}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TagDto(
        String id,
        @NotNull @NotBlank String label
) implements Serializable {

    public TagDto(@NotNull @NotBlank String label) {
        this(null, label);
    }
}
