package com.exnihilo.repositories;

import com.exnihilo.domains.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends BaseRepository<Tag, String> {

    @Query("select t from Tag t where upper(t.label) = upper(?1)")
    Optional<Tag> findByLabel(String label);

}
