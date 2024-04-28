package com.exnihilo.repositories;

import com.exnihilo.domains.entities.Person;
import com.exnihilo.domains.entities.Ticket;
import com.exnihilo.domains.enums.TicketStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, String> {

    @Query("select t from Ticket t where t.openedBy = ?1")
    List<Ticket> findByOpenedBy(Person openedBy);

    @Query("select t from Ticket t where t.closedBy = ?1")
    List<Ticket> findByClosedBy(Person closedBy);

    @Query("select t from Ticket t where t.status = ?1")
    List<Ticket> findByStatus(TicketStatus status);

    @Query("select t from Ticket t where upper(t.label) like upper(concat('%', ?1, '%'))")
    List<Ticket> findByLabel(String label);

    @Query("select t from Ticket t where upper(t.description) like upper(concat('%', ?1, '%'))")
    List<Ticket> findByDescription(String description);

    @Query("select count(t) from Ticket t where t.status = ?1")
    long countByStatus(TicketStatus status);

    @Query("""
            select t from Ticket t
            where upper(t.description) like upper(concat('%', ?1, '%'))
            or upper(t.label) like upper(concat('%', ?1, '%'))""")
    List<Ticket> search(String s);

}
