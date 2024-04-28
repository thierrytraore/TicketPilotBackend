package com.exnihilo.domains.entities;

import com.exnihilo.domains.enums.PersonRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person extends BaseEntity {

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @OneToMany(mappedBy = "person")
    private List<Assignment> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "closedBy")
    private List<Ticket> closedByTickets = new ArrayList<>();

    @OneToMany(mappedBy = "openedBy")
    private List<Ticket> openedByTickets = new ArrayList<>();

}