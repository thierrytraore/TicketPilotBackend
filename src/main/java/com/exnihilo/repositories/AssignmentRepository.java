package com.exnihilo.repositories;

import com.exnihilo.domains.entities.Assignment;
import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.entities.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends BaseRepository<Assignment, String> {

    @Query("select a from Assignment a where a.person = ?1")
    List<Assignment> findByUser(Person person);

    @Query("select a from Assignment a where a.ticket = ?1")
    List<Assignment> findByTicket(Ticket ticket);

    @Query("select a from Assignment a where a.person = ?1 and a.ticket = ?2")
    Optional<Assignment> findByUserAndTicket(Person person, Ticket ticket);

}
