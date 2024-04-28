package com.exnihilo.repositories;

import com.exnihilo.domains.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID>
        extends JpaSpecificationExecutor<T>, JpaRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
