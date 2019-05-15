package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ClauseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClauseRepository extends PagingAndSortingRepository<ClauseEntity, Long> {
    ClauseEntity findByClsCode(int clsCode);
}
