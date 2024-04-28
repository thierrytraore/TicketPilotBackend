package com.exnihilo.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {

    @Column(name = "label", nullable = false, unique = true)
    private String label;

    @ManyToMany(mappedBy = "tags")
    private List<Ticket> tickets;

    public Tag(String label) {
        this.label = label;
    }

}
