package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonLoginDto(@NotNull @NotBlank String email,
                             @NotNull @NotBlank String password
) implements Serializable {
}
