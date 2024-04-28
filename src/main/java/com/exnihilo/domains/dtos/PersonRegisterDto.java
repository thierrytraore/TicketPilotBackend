package com.exnihilo.domains.dtos;

import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.enums.PersonRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonRegisterDto(
        String id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        String password,
        PersonRole role
) implements Serializable {
}
