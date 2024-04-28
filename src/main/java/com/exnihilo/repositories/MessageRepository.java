package com.exnihilo.repositories;

import com.exnihilo.domains.entities.Assignment;
import com.exnihilo.domains.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends BaseRepository<Message, String> {

    @Query("select m from Message m where m.assignment = ?1")
    Optional<Message> findByAssignment(Assignment assignment);

    @Query("select m from Message m where upper(m.content) like upper(concat('%', ?1, '%'))")
    List<Message> findByContentContains(String content);

}
