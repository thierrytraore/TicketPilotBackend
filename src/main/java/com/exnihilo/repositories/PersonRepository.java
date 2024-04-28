package com.exnihilo.repositories;

import com.exnihilo.domains.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends BaseRepository<Person, String> {

    @Query("select u from Person u where upper(u.email) = upper(?1)")
    Optional<Person> findByEmail(String email);

}
