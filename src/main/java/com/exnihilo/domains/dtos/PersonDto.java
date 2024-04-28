package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.enums.PersonRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonDto(
        String id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        @NotNull PersonRole role
) implements Serializable {

    public PersonDto(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, @NotNull PersonRole role) {
        this(null, firstName, lastName, email, role);
    }

}
